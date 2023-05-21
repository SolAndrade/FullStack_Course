package com.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.Length;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountDTO {

    @NotBlank
    @PositiveOrZero
    private BigDecimal initialBalance;

    @NotBlank
    @Length(min = 3, max = 3, message = "Must be of 3 LETTERS.")
    private String currency;

    @NotBlank
    @Positive
    private Long primaryOwnerId;

    @NotBlank
    private String primaryOwnerUsername;

    @Positive
    private Long secondaryOwnerId;

    private String secondaryOwnerUsername;

}