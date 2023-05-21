package com.banking.models.accounts;

import com.banking.enums.Status;
import com.banking.models.Money;
import com.banking.models.accounts.StudentCheckingAccount;
import com.banking.models.users.AccountHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class StudentCheckingAccountTest {
    @Test
    public void studentCheckingAccountConstructor_ShouldSetFieldsCorrectly() {
        Money balance = new Money(BigDecimal.valueOf(1000));
        int secretKey = 1234;
        AccountHolder primaryOwner = new AccountHolder();
        AccountHolder secondaryOwner = new AccountHolder();

        StudentCheckingAccount studentCheckingAccount = new StudentCheckingAccount(balance, secretKey, primaryOwner, secondaryOwner);

        Assertions.assertEquals(balance, studentCheckingAccount.getBalance());
        Assertions.assertEquals(secretKey, studentCheckingAccount.getSecretKey());
        Assertions.assertEquals(primaryOwner, studentCheckingAccount.getPrimaryOwner());
        Assertions.assertEquals(secondaryOwner, studentCheckingAccount.getSecondaryOwner());
        Assertions.assertEquals(Status.ACTIVE, studentCheckingAccount.getStatus());
    }
}
