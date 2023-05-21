package com.banking.models.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdminTest {
    @Test
    public void adminConstructor_ShouldSetFieldsCorrectly() {
        String username = "admin_user";
        String password = "admin123";
        String name = "Admin User";

        Admin admin = new Admin(username, password, name);

        Assertions.assertEquals(username, admin.getUsername());
        Assertions.assertEquals(password, admin.getPassword());
        Assertions.assertEquals(name, admin.getName());
    }
}
