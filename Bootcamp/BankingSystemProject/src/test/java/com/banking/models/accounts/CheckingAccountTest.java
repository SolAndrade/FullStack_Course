package com.banking.models.accounts;

import com.banking.enums.Status;
import com.banking.models.Money;
import com.banking.models.accounts.CheckingAccount;
import com.banking.models.users.AccountHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CheckingAccountTest {
    @Test
    public void checkingAccountConstructor_ShouldSetFieldsCorrectly() {
        Money balance = new Money(BigDecimal.valueOf(1000));
        int secretKey = 1234;
        AccountHolder primaryOwner = new AccountHolder();
        AccountHolder secondaryOwner = new AccountHolder();

        CheckingAccount checkingAccount = new CheckingAccount(balance, secretKey, primaryOwner, secondaryOwner);

        Assertions.assertEquals(balance, checkingAccount.getBalance());
        Assertions.assertEquals(secretKey, checkingAccount.getSecretKey());
        Assertions.assertEquals(primaryOwner, checkingAccount.getPrimaryOwner());
        Assertions.assertEquals(secondaryOwner, checkingAccount.getSecondaryOwner());
        Assertions.assertEquals(Status.ACTIVE, checkingAccount.getStatus());
        Assertions.assertEquals(LocalDate.now(), checkingAccount.getLatestFeeDate());
    }
}
