package com.banking.models.users;

import com.banking.models.Address;
import com.banking.models.accounts.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountHolderTest {
    @Test
    public void accountHolderConstructor_ShouldSetFieldsCorrectly() {
        String username = "john_doe";
        String password = "password123";
        String name = "John Doe";
        LocalDate dateOfBirth = LocalDate.of(1990, 5, 10);
        Address primaryAddress = new Address("123 Main St", "City", "12345", "State", "Country");
        Address mailingAddress = new Address("456 Elm St", "City", "54321", "State", "Country");

        AccountHolder accountHolder = new AccountHolder(username, password, name, dateOfBirth, primaryAddress, mailingAddress);

        Assertions.assertEquals(password, accountHolder.getPassword());
        Assertions.assertEquals(username, accountHolder.getUsername());
        Assertions.assertEquals(name, accountHolder.getName());
        Assertions.assertEquals(dateOfBirth, accountHolder.getDateOfBirth());
        Assertions.assertEquals(primaryAddress, accountHolder.getPrimaryAddress());
        Assertions.assertEquals(mailingAddress, accountHolder.getMailingAddress());
    }

    @Test
    public void accountHolderAccounts_ShouldBeEmptyInitially() {
        AccountHolder accountHolder = new AccountHolder();

        List<Account> accounts = accountHolder.getAccounts();

        Assertions.assertTrue(accounts.isEmpty());
    }

    @Test
    public void accountHolderSecondaryAccounts_ShouldBeEmptyInitially() {
        AccountHolder accountHolder = new AccountHolder();

        List<Account> secondaryAccounts = accountHolder.getSecondaryAccounts();

        Assertions.assertTrue(secondaryAccounts.isEmpty());
    }

    @Test
    public void accountHolderAccounts_ShouldBePopulated() {
        AccountHolder accountHolder = new AccountHolder();
        Account account1 = new Account();
        Account account2 = new Account();
        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);

        accountHolder.setAccounts(accounts);

        Assertions.assertEquals(accounts, accountHolder.getAccounts());
    }
}
