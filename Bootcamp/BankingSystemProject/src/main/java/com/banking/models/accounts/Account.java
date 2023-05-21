package com.banking.models.accounts;

import com.banking.models.users.AccountHolder;
import com.banking.models.Money;
import com.banking.enums.Status;

import com.sun.istack.NotNull;
import lombok.*;
import com.banking.models.Transaction;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nbr;
    @Embedded
    private Money balance;
    private int secretKey;
    @ManyToOne
    @JoinColumn(name = "primary_owner_id")
    private AccountHolder primaryOwner;
    @ManyToOne
    @JoinColumn(name = "secondary_owner_id")
    private AccountHolder secondaryOwner;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "penalty_currency")),
            @AttributeOverride(name = "amount", column = @Column(name = "penalty_amount"))
    })
    private final Money penaltyFee = new Money(BigDecimal.valueOf(40));
    private final LocalDate creationDate = LocalDate.now();
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(mappedBy = "origin", cascade = CascadeType.ALL)
    private List<Transaction> outgoingTransactions;
    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    private List<Transaction> incomingTransactions;

    public Account(Money balance, int secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        this.balance = balance;
        this.secretKey = secretKey;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.status = Status.ACTIVE;
    }
}