package org.item04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MathUtilsTest {
    static Stream<Long> primeProvider() {
        return Stream.of(
                2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L,
                100000000003L, 100000000019L, 100000000057L, 100000000069L,
                100000000183L, 100000000211L, 100000000237L, 12345678929L,
                100000000253L, 100000000283L, 100000000319L, 100000000363L,
                100000000367L, 100000000379L, 100000000393L, 100000000403L,
                100000000411L, 100000000417L, 100000000427L, 100000000447L);
    }

    static Stream<Long> compositeProvider() {
        return Stream.of(
                0L, 1L, 4L, 6L, 8L, 9L, 10L,
                100000000081L, // 네가 실패한 케이스: 합성수
                100000000085L, // 예시 합성수
                12345678918L, 12345678920L);
    }

    @ParameterizedTest
    @MethodSource("primeProvider")
    void isPrime_primesShouldPass(long n) {
        assertTrue(MathUtils.isPrime(n), () -> n + "은 소수로 판별");
    }

    @ParameterizedTest
    @MethodSource("compositeProvider")
    void isPrime_compositesShouldFail(long n) {
        assertFalse(MathUtils.isPrime(n), () -> n + "은 합성수로 판별");
    }

    @Test
    void allConstructor_shouldBePrivate() throws Exception {
        Constructor<?>[] ctors = MathUtils.class.getDeclaredConstructors();
        assertEquals(1, ctors.length);

        for (Constructor<?> ctor : ctors) {
            assertTrue(
                    Modifier.isPrivate(ctor.getModifiers()),
                    "Contructor " + ctor + " should be private");
        }
    }
}
