package com.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
public class ThirdPartyDTO {
    private String name;
    @Column(unique = true)
    private String hashedKey;
}
