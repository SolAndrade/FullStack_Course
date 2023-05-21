package com.banking.dto;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class AccountHolderDTO {
    @NotEmpty
    @Column(unique = true)
    private String username;
    @NotEmpty
    private String name;
    @NotEmpty
    @Column(nullable = false)
    private String password;
    @DateTimeFormat(pattern = "dd/MM/yyy")
    private LocalDate dateOfBirth;
    @NotEmpty
    private String city;
    @NotEmpty
    private String streetAddress;
    @Nullable
    @Size(max = 12)
    private String postalCode;
    @Nullable
    private String country;
    @Nullable
    private String provinceState;
    @NotEmpty
    private String mailCity;
    @Nullable
    private String mailCountry;
    @Nullable
    private String mailStreetAddress;
    @Nullable
    private String mailProvinceState;
    @Nullable
    @Size(max = 12)
    private String mailPostalCode;

    public AccountHolderDTO() {

    }
}
