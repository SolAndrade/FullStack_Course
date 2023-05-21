package com.banking.dto;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@Getter
@Setter
@AllArgsConstructor
public class CreditCardAccountDTO {
    @NotNull
    private final BigDecimal balanceAmount;
    @NotEmpty
    private final int secretKey;
    @NotNull
    private final Long primaryOwnerId;
    @Nullable
    private final Long secondaryOwnerId;
    @DecimalMax(value = "10000")
    @DecimalMin(value = "100")
    private final BigDecimal creditLimitAmount;
    @DecimalMax(value = "0.2")
    @DecimalMin(value = "0.1")
    private final BigDecimal interestRate;
}
