package com.banking.controllers;

import com.banking.dto.*;
import com.banking.models.Money;
import com.banking.models.Transaction;
import com.banking.models.accounts.Account;
import com.banking.models.accounts.CreditCardAccount;
import com.banking.models.accounts.SavingsAccount;
import com.banking.models.users.AccountHolder;
import com.banking.models.users.Admin;
import com.banking.models.users.ThirdParty;
import com.banking.models.users.User;
import com.banking.services.interfaces.AppServiceInterface;
import com.banking.services.interfaces.AppUserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class AppController {
    @Autowired
    AppServiceInterface appServiceInterface;
    @Autowired
    AppUserServiceInterface appUserServiceInterface;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> showUsers(@AuthenticationPrincipal UserDetails userDetails) {
        return appUserServiceInterface.showUsers(userDetails);
    }

    @PostMapping("/users/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin addAdmin(@RequestBody AdminDTO admin) {
        return appUserServiceInterface.addAdmin(admin);
    }

    @PostMapping("/users/client")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder addAccountHolder(@RequestBody AccountHolderDTO accountHolder) {
        return appUserServiceInterface.addAccountHolder(accountHolder);
    }

    @PostMapping("/users/third-party")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty addThirdParty(@RequestBody ThirdPartyDTO thirdParty) {
        return appUserServiceInterface.addThirdParty(thirdParty);
    }

    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> showAccounts() {
        return appServiceInterface.showAccounts();
    }

    @PostMapping("/accounts/checking")
    @ResponseStatus(HttpStatus.CREATED)
    public Account newCheckingAccount(@RequestBody CheckingAccountDTO checkingAccount) {
        return appServiceInterface.newCheckingAccount(checkingAccount);
    }

    @PostMapping("/accounts/savings")
    @ResponseStatus(HttpStatus.CREATED)
    public SavingsAccount newSavingsAccount(@RequestBody SavingsAccountDTO savingsAccountDTO) {
        return appServiceInterface.newSavingsAccount(savingsAccountDTO);
    }

    @PostMapping("/accounts/credit-card")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCardAccount newCreditCardAccount(@RequestBody CreditCardAccountDTO creditCardAccountDTO) {
        return appServiceInterface.newCreditCardAccount(creditCardAccountDTO);
    }

    @GetMapping("/check-balance")
    @ResponseStatus(HttpStatus.FOUND)
    public Money checkBalance(@RequestParam Long id) {
        return appServiceInterface.checkBalance(id);
    }

    @PatchMapping("/accounts/modify-balance")
    @ResponseStatus(HttpStatus.OK)
    public void modifyBalance(@RequestParam Long id, @RequestParam BigDecimal amount) {
        appServiceInterface.checkBalance(id);
        appServiceInterface.modifyBalance(id, amount);
        appServiceInterface.checkBalance(id);
    }

    @PatchMapping("/transfer")
    @ResponseStatus(HttpStatus.OK)
    public Transaction transferBetweenAccounts(TransferDTO transfer) {
        return appServiceInterface.transferBetweenAccounts(transfer);
    }

    @PatchMapping("/third-party/to")
    @ResponseStatus(HttpStatus.OK)
    public Transaction transferToThirdParty(@RequestBody ThirdPartyTransferDTO thirdPartyTransferDTO, @RequestHeader String hashedKey) {
        return appServiceInterface.transferToThirdParty(thirdPartyTransferDTO, hashedKey);
    }

    @PatchMapping("/third-party/from")
    @ResponseStatus(HttpStatus.OK)
    public Transaction transferFromThirdParty(@RequestBody ThirdPartyTransferDTO thirdPartyTransferDTO, @RequestHeader String hashedKey) {
        return appServiceInterface.transferFromThirdParty(thirdPartyTransferDTO, hashedKey);
    }
}
