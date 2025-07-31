package org.item03;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class ConfigServiceTest {

    @Test
    void singleton_getInstanceReturnsSameObject() {
        ConfigService first = ConfigService.getInstance();
        ConfigService second = ConfigService.getInstance();
        assertSame(first, second);
    }
}
