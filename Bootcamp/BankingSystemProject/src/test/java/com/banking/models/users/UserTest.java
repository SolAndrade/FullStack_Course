package com.banking.models.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void userConstructor_ShouldSetFieldsCorrectly() {
        String username = "test_user";
        String password = "test123";
        String name = "Test User";

        User user = new User(username, password, name);

        Assertions.assertEquals(username, user.getUsername());
        Assertions.assertEquals(password, user.getPassword());
        Assertions.assertEquals(name, user.getName());
    }
}
