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
public class CheckingAccount extends Account {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "min_balance_currency")),
            @AttributeOverride(name = "amount", column = @Column(name = "min_balance_amount"))
    })
    private final Money minBalance = new Money(BigDecimal.valueOf(250));
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "maintenance_currency")),
            @AttributeOverride(name = "amount", column = @Column(name = "maintenance_amount"))
    })
    private final Money monthlyMaintenanceFee = new Money(BigDecimal.valueOf(12));
    private LocalDate latestFeeDate;

    public CheckingAccount(Money balance, int secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        super(balance, secretKey, primaryOwner, secondaryOwner);
        this.latestFeeDate = LocalDate.now();
    }
}