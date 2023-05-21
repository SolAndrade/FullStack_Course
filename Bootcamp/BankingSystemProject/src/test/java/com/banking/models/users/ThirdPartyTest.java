package com.banking.models.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThirdPartyTest {
    @Test
    public void thirdPartyConstructor_ShouldSetFieldsCorrectly() {
        String name = "Third Party User";
        String hashedKey = "hash123";

        ThirdParty thirdParty = new ThirdParty(name, hashedKey);

        Assertions.assertEquals(name, thirdParty.getName());
        Assertions.assertEquals(hashedKey, thirdParty.getHashedKey());
    }
}
