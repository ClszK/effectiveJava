package org.item02;

import lombok.Getter;

@Getter
public class User {
    private final String username;
    private final String email;
    private final int age;
    private final String address;
    private final boolean newsletterOptIn;

    private User(Builder b) {
        this.username = b.username;
        this.email = b.email;
        this.age = b.age;
        this.address = b.address;
        this.newsletterOptIn = b.newsletterOptIn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String username = "";
        private String email = "";
        private int age = 0;
        private String address = "";
        private boolean newsletterOptIn = false;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }
        public Builder newsletterOptIn(
        boolean newsletterOptIn) {
            this.newsletterOptIn = newsletterOptIn;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
