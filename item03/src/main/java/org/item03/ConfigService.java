package org.item03;

import java.util.HashMap;
import java.util.Map;

public class ConfigService {

    private static final ConfigService INSTANCE = new ConfigService();
    private final Map<String, String> configs = new HashMap<>();

    private ConfigService() { }

    public static ConfigService getInstance() {
        return INSTANCE;
    }

    public String getProperty(String key) {
        return configs.getOrDefault(key, "");
    }
}
