package org.item03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 싱글턴임이 API에서 명확히 드러나야함
 * 인스턴스는 한 번만 생성.
 * 간단한 카운팅 기능(increase(), getCount())를 갖는다.
 */
public class CounterServiceTest {

    @BeforeEach
    void resetCounter() {
        CounterService.INSTANCE.reset();
    }

    @Test
    void singleton_onlyOneInstanceExists() {
        CounterService first = CounterService.INSTANCE;
        CounterService second = CounterService.INSTANCE;

        assertSame(first, second);
    }

    @Test
    void singleton_defaultCountIsZero() {
        assertEquals(0, CounterService.INSTANCE.getCount());
    }

    @Test
    void singleton_increaseIncrementsCount() {
        CounterService.INSTANCE.increase();
        assertEquals(1, CounterService.INSTANCE.getCount());
    }
}
