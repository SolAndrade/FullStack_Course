package com.banking.models.users;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ThirdParty extends User{
    @Column(nullable = false, unique = true)
    private String hashedKey;

    public ThirdParty(String name, String hashedKey) {
        super(null, null, name);
        this.hashedKey = hashedKey;
    }
}