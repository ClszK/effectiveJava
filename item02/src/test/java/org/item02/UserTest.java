package org.item02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void builder_withRequiredOnly_buildsSuccessfully() {
        User user = User.builder()
                        .username("alice")
                        .email("alice@example.com")
                        .build();

        assertEquals("alice", user.getUsername());
        assertEquals("alice@example.com", user.getEmail());
    }
}
