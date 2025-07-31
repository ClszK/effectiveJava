package org.item01;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * NumberWrapperFactory.of(Number n)
 * - n instanceof Intger -> IntegerWrapper 반환
 * - n instanceof Double -> DoubleWrapper 반환
 * - 그외 -> IllegalArgumentException 발생
 */
public class NumberWrapperFactoryTest {

    @Test
    void of_IntegerShouldReturnIntegerWrapper() {
        NumberWrapper w = NumberWrapperFactory.of(42);
        assertTrue(w instanceof IntegerWrapper);
    }

    @Test
    void of_DoubleShouldReturnDoubleWrapper() {
        NumberWrapper w = NumberWrapperFactory.of(3.14);
        assertTrue(w instanceof DoubleWrapper);
    }

    @Test
    void of_UnsupportedShouldThrow() {
        assertThrows(IllegalArgumentException.class,
                () -> NumberWrapperFactory.of(1L));
    }

}
