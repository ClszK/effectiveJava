package org.item02;

import lombok.Getter;

@Getter
public class User {
    private final String username;
    private final String email;

    private User(Builder b) {
        this.username = b.username;
        this.email = b.email;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        String username;
        String email;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
