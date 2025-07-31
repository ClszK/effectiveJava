package org.item02;

import static org.junit.jupiter.api.Assertions.assertAll;
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

    @Test
    void builder_defaultOptionalValues() {
        User user = User.builder()
                .username("bob")
                .email("bob@example.com")
                .build();

        assertAll("User 생성 테스트",
                () -> assertEquals(0, user.getAge()),
                () -> assertEquals("", user.getAddress()),
                () -> assertFalse(user.isNewsletterOptIn()));

    }
}
