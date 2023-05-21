package com.banking.models.accounts;

import com.banking.enums.Status;
import com.banking.models.Money;
import com.banking.models.accounts.Account;
import com.banking.models.users.AccountHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AccountTest {
    @Test
    public void accountConstructor_ShouldSetFieldsCorrectly() {
        Money balance = new Money(BigDecimal.valueOf(1000));
        int secretKey = 1234;
        AccountHolder primaryOwner = new AccountHolder();
        AccountHolder secondaryOwner = new AccountHolder();

        Account account = new Account(balance, secretKey, primaryOwner, secondaryOwner);

        Assertions.assertEquals(balance, account.getBalance());
        Assertions.assertEquals(secretKey, account.getSecretKey());
        Assertions.assertEquals(primaryOwner, account.getPrimaryOwner());
        Assertions.assertEquals(secondaryOwner, account.getSecondaryOwner());
        Assertions.assertEquals(Status.ACTIVE, account.getStatus());
    }
}
