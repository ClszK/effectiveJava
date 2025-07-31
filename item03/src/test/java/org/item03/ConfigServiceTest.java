package org.item03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.lang.reflect.Field;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConfigServiceTest {

    @BeforeEach
    void reset_configs_viaReflection() throws Exception {
        Field configsField = ConfigService.class.getDeclaredField("configs");
        configsField.setAccessible(true);

        @SuppressWarnings("unchecked")
        Map<String, String> configs = (Map<String, String>) configsField.get(ConfigService.getInstance());
        configs.clear();
    }

    @Test
    void singleton_getInstanceReturnsSameObject() {
        ConfigService first = ConfigService.getInstance();
        ConfigService second = ConfigService.getInstance();
        assertSame(first, second);
    }

    @Test
    void config_defaultPropertyIsEmpty() {
        ConfigService cfs = ConfigService.getInstance();
        assertEquals("", cfs.getProperty("anyKey"));
    }

    @Test
    void config_setAndGetProperty() {
        ConfigService.getInstance().setProperty("url", "https://api.example.com");

        assertEquals("https://api.example.com",
                ConfigService.getInstance().getProperty("url"));
    }

    @Test
    void config_overwritePropertyReflectsNewValue() {
        ConfigService.getInstance().setProperty("mode", "dev");
        ConfigService.getInstance().setProperty("mode", "prod");

        assertEquals("prod", ConfigService.getInstance().getProperty("mode"));
    }
}
