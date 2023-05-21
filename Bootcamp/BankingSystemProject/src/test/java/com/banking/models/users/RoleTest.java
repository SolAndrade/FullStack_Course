package com.banking.models.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoleTest {
    @Test
    public void roleConstructor_ShouldSetFieldsCorrectly() {
        String roleName = "ROLE_ADMIN";
        User user = new User("admin", "admin123", "Admin User");

        Role role = new Role(roleName, user);

        Assertions.assertEquals(roleName, role.getRole());
        Assertions.assertEquals(user, role.getUser());
    }
}
