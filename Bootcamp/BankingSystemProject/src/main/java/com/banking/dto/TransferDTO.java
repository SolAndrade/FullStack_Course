package com.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class TransferDTO {
    private String senderName;
    private long originId;
    private long destinationId;
    private BigDecimal amount;
}
