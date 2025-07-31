package org.item03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class ConfigServiceTest {

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
        ConfigService cfs = ConfigService.getInstance();
        cfs.setProperty("url", "https://api.example.com");

        assertEquals("https://api.example.com", 
            cfs.getProperty("url"));
    }
}
