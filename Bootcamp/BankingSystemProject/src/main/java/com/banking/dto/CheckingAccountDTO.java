package com.banking.dto;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Data
@Getter
@Setter
@AllArgsConstructor
public class CheckingAccountDTO {
    @DecimalMin(value = "250")
    private BigDecimal balanceAmount;
    @NotNull
    @Digits(integer = 4, fraction = 0)
    private int secretKey;
    @NotNull
    private Long primaryOwnerId;
    @Nullable
    private Long secondaryOwnerId;
}
