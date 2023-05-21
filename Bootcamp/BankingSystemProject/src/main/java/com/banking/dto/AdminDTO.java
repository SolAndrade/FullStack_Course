package com.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
public class AdminDTO {
    @NotEmpty
    @Column(unique = true)
    private String username;
    @NotEmpty
    @Column(nullable = false)
    private String password;
    @NotEmpty
    private String name;

    public AdminDTO() {

    }
}