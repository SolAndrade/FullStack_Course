package com.banking.models;

import com.banking.models.accounts.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionTest {
    @Test
    public void transactionConstructor_WithAccounts_ShouldSetFieldsCorrectly() {
        String senderName = "Sender";
        Account origin = new Account();
        Account destination = new Account();
        Money amount = new Money(BigDecimal.valueOf(100));

        Transaction transaction = new Transaction(senderName, origin, destination, amount);

        Assertions.assertEquals(senderName, transaction.getSenderName());
        Assertions.assertEquals(origin, transaction.getOrigin());
        Assertions.assertEquals(destination, transaction.getDestination());
        Assertions.assertEquals(amount, transaction.getAmount());
    }

    @Test
    public void transactionConstructor_WithAmount_ShouldSetAmountFieldCorrectly() {
        Money amount = new Money(BigDecimal.valueOf(100));

        Transaction transaction = new Transaction(amount);

        Assertions.assertEquals(amount, transaction.getAmount());
    }

    @Test
    public void transactionTimeOfTransaction_ShouldBeCurrentTime() {
        Transaction transaction = new Transaction(new Money(BigDecimal.valueOf(100)));

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime transactionTime = transaction.getTimeOfTransaction();

        Assertions.assertTrue(transactionTime.isAfter(currentTime.minusSeconds(1)));
        Assertions.assertTrue(transactionTime.isBefore(currentTime.plusSeconds(1)));
    }
}
