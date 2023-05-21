package com.banking.models.accounts;

import com.banking.models.users.AccountHolder;
import com.banking.models.Money;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CreditCardAccount extends Account{
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "credit_currency")),
            @AttributeOverride(name = "amount", column = @Column(name = "credit_amount"))
    })
    private Money creditLimit;
    private BigDecimal interestRate = BigDecimal.valueOf(0.0025);
    private LocalDate latestInterestDate = LocalDate.now();

    public CreditCardAccount(Money balance, int secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money creditLimit, BigDecimal interestRate) {
        super(balance, secretKey, primaryOwner, secondaryOwner);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

}
