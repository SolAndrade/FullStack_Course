package com.banking.models.accounts;

import com.banking.models.Money;
import com.banking.models.users.AccountHolder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StudentCheckingAccount extends Account{

    public StudentCheckingAccount(Money balance, int secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        super(balance, secretKey, primaryOwner, secondaryOwner);
    }
}