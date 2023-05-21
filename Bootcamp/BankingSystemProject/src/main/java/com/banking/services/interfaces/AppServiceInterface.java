package com.banking.services.interfaces;

import com.banking.dto.*;
import com.banking.models.Money;
import com.banking.models.Transaction;
import com.banking.models.accounts.Account;
import com.banking.models.accounts.CreditCardAccount;
import com.banking.models.accounts.SavingsAccount;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

public interface AppServiceInterface {
    List<Account> showAccounts();
    Account newCheckingAccount(CheckingAccountDTO checkingAccount);
    SavingsAccount newSavingsAccount(SavingsAccountDTO savingsAccount);
    CreditCardAccount newCreditCardAccount(CreditCardAccountDTO creditCardAccount);
    Money checkBalance(Long id);
    void modifyBalance(Long id, BigDecimal amount);
    Transaction transferBetweenAccounts(TransferDTO transfer);
    Transaction transferToThirdParty(ThirdPartyTransferDTO transfer, String hashedKey);
    Transaction transferFromThirdParty(ThirdPartyTransferDTO transfer, String hashedKey);
}
