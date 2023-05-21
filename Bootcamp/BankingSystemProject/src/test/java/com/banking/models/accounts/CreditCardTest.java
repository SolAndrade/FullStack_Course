package com.banking.models.accounts;

import com.banking.enums.Status;
import com.banking.models.Money;
import com.banking.models.accounts.CreditCardAccount;
import com.banking.models.users.AccountHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CreditCardTest {
    @Test
    public void creditCardAccountConstructor_ShouldSetFieldsCorrectly() {
        Money balance = new Money(BigDecimal.valueOf(1000));
        int secretKey = 1234;
        AccountHolder primaryOwner = new AccountHolder();
        AccountHolder secondaryOwner = new AccountHolder();
        Money creditLimit = new Money(BigDecimal.valueOf(5000));
        BigDecimal interestRate = BigDecimal.valueOf(0.002);

        CreditCardAccount creditCardAccount = new CreditCardAccount(balance, secretKey, primaryOwner, secondaryOwner, creditLimit, interestRate);

        Assertions.assertEquals(balance, creditCardAccount.getBalance());
        Assertions.assertEquals(secretKey, creditCardAccount.getSecretKey());
        Assertions.assertEquals(primaryOwner, creditCardAccount.getPrimaryOwner());
        Assertions.assertEquals(secondaryOwner, creditCardAccount.getSecondaryOwner());
        Assertions.assertEquals(Status.ACTIVE, creditCardAccount.getStatus());
        Assertions.assertEquals(creditLimit, creditCardAccount.getCreditLimit());
        Assertions.assertEquals(interestRate, creditCardAccount.getInterestRate());
    }
}
