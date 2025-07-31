package org.item02;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void builder_withOptionalFields() {
        User user = User.builder()
                .username("cathy")
                .email("cathy@example.com")
                .age(28)
                .address("Seoul")
                .newsletterOptIn(true)
                .build();

        assertAll(
                () -> assertEquals(28, user.getAge()),
                () -> assertEquals("Seoul", user.getAddress()),
                () -> assertTrue(user.isNewsletterOptIn()));
    }

    @Test
    void build_withoutUsername_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> User.builder()
                        .email("e@e.com")
                        .build());
    }

    @Test
    void build_withInvalidEmail_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> User.builder()
                        .username("dave")
                        .email("not-an-email")
                        .build());
    }
}

