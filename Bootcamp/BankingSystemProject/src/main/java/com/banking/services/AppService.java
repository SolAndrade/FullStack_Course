package com.banking.services;

import com.banking.dto.*;
import com.banking.repositories.*;
import com.banking.services.interfaces.AppServiceInterface;
import com.banking.models.Money;
import com.banking.models.Transaction;
import com.banking.models.accounts.*;
import com.banking.models.users.AccountHolder;
import com.banking.models.users.ThirdParty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class AppService implements AppServiceInterface {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CheckingAccountRepository checkingAccountRepository;
    @Autowired
    StudentCheckingAccountRepository studentCheckingAccountRepository;
    @Autowired
    SavingsAccountRepository savingsAccountRepository;
    @Autowired
    CreditCardAccountRepository creditCardAccountRepository;
    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    ThirdPartyRepository thirdPartyRepository;
    @Autowired
    TransactionRepository transactionRepository;

    public List<Account> showAccounts() {
        return accountRepository.findAll();
    }

    public Account newCheckingAccount(CheckingAccountDTO checkingAccount) {
        Money balance = new Money(checkingAccount.getBalanceAmount());
        int secretKey = checkingAccount.getSecretKey();
        AccountHolder primaryOwner = accountHolderRepository.findById(checkingAccount.getPrimaryOwnerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        AccountHolder secondaryOwner = null;
        if (checkingAccount.getSecondaryOwnerId() != null && accountHolderRepository.existsById(checkingAccount.getSecondaryOwnerId())) {
            secondaryOwner = accountHolderRepository.findById(checkingAccount.getSecondaryOwnerId()).get();
        }
        int age = Period.between(primaryOwner.getDateOfBirth(), LocalDate.now()).getYears();
        if (age < 18) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Must be 18 years old");
        } else if (age >= 18 && age < 24) {
            return studentCheckingAccountRepository.save(new StudentCheckingAccount(balance, secretKey, primaryOwner, secondaryOwner));
        } else {
            return checkingAccountRepository.save(new CheckingAccount(balance, secretKey, primaryOwner, secondaryOwner));
        }
    }

    public SavingsAccount newSavingsAccount(SavingsAccountDTO savingsAccount) {
        Money balance = new Money(savingsAccount.getBalanceAmount());
        int secretKey = savingsAccount.getSecretKey();
        AccountHolder primaryOwner = accountHolderRepository.findById(savingsAccount.getPrimaryOwnerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        AccountHolder secondaryOwner = null;
        if (savingsAccount.getSecondaryOwnerId() != null && accountHolderRepository.existsById(savingsAccount.getSecondaryOwnerId())) {
            secondaryOwner = accountHolderRepository.findById(savingsAccount.getSecondaryOwnerId()).get();
        }
        Money minimumBalance = new Money(savingsAccount.getMinimumBalance());
        BigDecimal interestRate = savingsAccount.getInterestRate();
        return savingsAccountRepository.save(new SavingsAccount(balance, secretKey, primaryOwner, secondaryOwner, minimumBalance, interestRate));
    }

    public CreditCardAccount newCreditCardAccount(CreditCardAccountDTO creditCardAccount) {
        Money balance = new Money(creditCardAccount.getBalanceAmount());
        int secretKey = creditCardAccount.getSecretKey();
        AccountHolder primaryOwner = accountHolderRepository.findById(creditCardAccount.getPrimaryOwnerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        AccountHolder secondaryOwner = null;
        if (creditCardAccount.getSecondaryOwnerId() != null && accountHolderRepository.existsById(creditCardAccount.getSecondaryOwnerId())) {
            secondaryOwner = accountHolderRepository.findById(creditCardAccount.getSecondaryOwnerId()).get();
        }
        BigDecimal interestRate = creditCardAccount.getInterestRate();
        Money creditLimit = new Money(creditCardAccount.getCreditLimitAmount());
        return creditCardAccountRepository.save(new CreditCardAccount(balance, secretKey, primaryOwner, secondaryOwner, creditLimit, interestRate));
    }

    public Money checkBalance(Long id) {
        if (!accountRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));

        if (account instanceof CheckingAccount) {
            CheckingAccount checkingAccount = (CheckingAccount) account;
            BigDecimal feeTime = BigDecimal.valueOf(Period.between(checkingAccount.getLatestFeeDate(), LocalDate.now()).getMonths());
            if (feeTime.compareTo(BigDecimal.ZERO) == 1) {
                modifyBalance(checkingAccount.getNbr(), checkingAccount.getMonthlyMaintenanceFee().getAmount().multiply(feeTime));
                checkingAccount.setLatestFeeDate(LocalDate.now());
                checkingAccountRepository.save(checkingAccount);
            }
            if (checkingAccount.getBalance().getAmount().compareTo(checkingAccount.getMinBalance().getAmount()) == -1) {
                modifyBalance(checkingAccount.getNbr(), checkingAccount.getPenaltyFee().getAmount());
                checkingAccountRepository.save(checkingAccount);
            }
        } else if (account instanceof SavingsAccount) {
            SavingsAccount savingsAccount = (SavingsAccount) account;
            BigDecimal interestTime = BigDecimal.valueOf(Period.between(savingsAccount.getLatestInterestDate(), LocalDate.now()).getYears());
            if (interestTime.compareTo(BigDecimal.ZERO) == 1) {
                modifyBalance(savingsAccount.getNbr(), savingsAccount.getBalance().getAmount().multiply(savingsAccount.getInterestRate()).multiply(interestTime));
                savingsAccount.setLatestInterestDate(LocalDate.now());
                savingsAccountRepository.save(savingsAccount);
            }
            if (savingsAccount.getBalance().getAmount().compareTo(savingsAccount.getMinimumBalance().getAmount()) == -1) {
                modifyBalance(savingsAccount.getNbr(), savingsAccount.getPenaltyFee().getAmount());
                savingsAccountRepository.save(savingsAccount);
            }
        } else if (account instanceof CreditCardAccount) {
            CreditCardAccount creditCardAccount = (CreditCardAccount) account;
            BigDecimal interestTime = BigDecimal.valueOf(Period.between(creditCardAccount.getLatestInterestDate(), LocalDate.now()).getMonths());
            if (interestTime.compareTo(BigDecimal.ZERO) == 1) {
                modifyBalance(creditCardAccount.getNbr(), creditCardAccount.getBalance().getAmount().multiply(creditCardAccount.getInterestRate()).multiply(interestTime));
                creditCardAccount.setLatestInterestDate(LocalDate.now());
                creditCardAccountRepository.save(creditCardAccount);
            }
            if (creditCardAccount.getBalance().getAmount().compareTo((creditCardAccount.getCreditLimit().getAmount().negate())) == -1) {
                modifyBalance(creditCardAccount.getNbr(), creditCardAccount.getPenaltyFee().getAmount());
                creditCardAccountRepository.save(creditCardAccount);
            }
        }

        return account.getBalance();
    }

    public void modifyBalance(Long id, BigDecimal amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        account.setBalance(new Money(account.getBalance().decreaseAmount(amount)));
        accountRepository.save(account);
    }

    public Transaction transferBetweenAccounts(TransferDTO transfer) {
        String sender = transfer.getSenderName();
        Account origin = getAccountById(transfer.getOriginId());
        Account destination = getAccountById(transfer.getDestinationId());
        Money amount = new Money(transfer.getAmount());

        validateSenderIsAuthorized(sender, origin);
        checkBalance(origin.getNbr());
        checkBalance(destination.getNbr());
        validateSufficientFunds(origin, amount);
        performTransfer(origin, destination, amount);
        checkBalance(origin.getNbr());
        checkBalance(destination.getNbr());

        return transactionRepository.save(new Transaction(sender, origin, destination, amount));
    }

    private Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    private void validateSenderIsAuthorized(String sender, Account origin) {
        String primaryOwnerName = origin.getPrimaryOwner().getName();
        String secondaryOwnerName = (origin.getSecondaryOwner() != null) ? origin.getSecondaryOwner().getName() : null;

        if (!sender.equals(primaryOwnerName) && !sender.equals(secondaryOwnerName)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }

    private void validateSufficientFunds(Account origin, Money amount) {
        if (origin.getBalance().getAmount().compareTo(amount.getAmount()) == -1) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Error, insufficient funds");
        }
    }

    private void performTransfer(Account origin, Account destination, Money amount) {
        modifyBalance(origin.getNbr(), amount.getAmount());
        modifyBalance(destination.getNbr(), amount.getAmount().negate());
    }

    public Transaction transferToThirdParty(ThirdPartyTransferDTO transfer, String hashedKey) {
        ThirdParty thirdParty = getThirdPartyById(transfer.getThirdPartyId());
        validateHashedKey(hashedKey, thirdParty);
        Account account = getAccountById(transfer.getAccountId());
        validateSecretKey(transfer.getSecretKey(), account);
        Money amount = new Money(transfer.getAmount());
        validateSufficientFunds(account, amount);
        performTransfer(account, amount);
        return transactionRepository.save(createTransaction(account, amount));
    }

    private ThirdParty getThirdPartyById(Long id) {
        return thirdPartyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    private void validateHashedKey(String hashedKey, ThirdParty thirdParty) {
        if (!hashedKey.equals(thirdParty.getHashedKey())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }

    private void validateSecretKey(int secretKey, Account account) {
        if (secretKey == account.getSecretKey()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }

    private void performTransfer(Account account, Money amount) {
        modifyBalance(account.getNbr(), amount.getAmount());
    }

    private Transaction createTransaction(Account account, Money amount) {
        Transaction transaction = new Transaction(amount);
        transaction.setOrigin(account);
        return transaction;
    }

    public Transaction transferFromThirdParty(ThirdPartyTransferDTO transfer, String hashedKey) {
        ThirdParty thirdParty = getThirdPartyById(transfer.getThirdPartyId());
        validateHashedKey(hashedKey, thirdParty);
        Account account = getAccountById(transfer.getAccountId());
        validateSecretKey(transfer.getSecretKey(), account);
        Money amount = new Money(transfer.getAmount());
        performTransfer(account, amount);
        return transactionRepository.save(createTransaction(account, amount));
    }
}
