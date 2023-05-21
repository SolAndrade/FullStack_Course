package com.banking.models.users;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String role;
    @ManyToOne
    private User user;

    public Role(String role, User user) {
        this.role = role;
        this.user = user;
    }
}