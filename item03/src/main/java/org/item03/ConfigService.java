package org.item03;

public class ConfigService {
    private static final ConfigService INSTANCE = new ConfigService();

    public static ConfigService getInstance() {
        return INSTANCE;
    }
}
