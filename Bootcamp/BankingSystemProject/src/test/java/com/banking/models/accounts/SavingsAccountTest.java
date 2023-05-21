package com.banking.models.accounts;

import com.banking.enums.Status;
import com.banking.models.Money;
import com.banking.models.accounts.SavingsAccount;
import com.banking.models.users.AccountHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class SavingsAccountTest {
    @Test
    public void savingsAccountConstructor_ShouldSetFieldsCorrectly() {
        Money balance = new Money(BigDecimal.valueOf(1000));
        int secretKey = 1234;
        AccountHolder primaryOwner = new AccountHolder();
        AccountHolder secondaryOwner = new AccountHolder();
        Money minimumBalance = new Money(BigDecimal.valueOf(500));
        BigDecimal interestRate = BigDecimal.valueOf(0.002);

        SavingsAccount savingsAccount = new SavingsAccount(balance, secretKey, primaryOwner, secondaryOwner, minimumBalance, interestRate);

        Assertions.assertEquals(balance, savingsAccount.getBalance());
        Assertions.assertEquals(secretKey, savingsAccount.getSecretKey());
        Assertions.assertEquals(primaryOwner, savingsAccount.getPrimaryOwner());
        Assertions.assertEquals(secondaryOwner, savingsAccount.getSecondaryOwner());
        Assertions.assertEquals(Status.ACTIVE, savingsAccount.getStatus());
        Assertions.assertEquals(minimumBalance, savingsAccount.getMinimumBalance());
        Assertions.assertEquals(interestRate, savingsAccount.getInterestRate());
    }
}
