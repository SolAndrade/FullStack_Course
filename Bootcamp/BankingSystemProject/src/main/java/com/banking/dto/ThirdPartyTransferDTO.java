package com.banking.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ThirdPartyTransferDTO {
    @NotNull
    private Long thirdPartyId;
    private String hashedKey;
    private Long accountId;
    private int secretKey;
    private BigDecimal amount;
}
