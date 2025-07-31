package org.item03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 싱글턴임이 API에서 명확히 드러나야함
 * 인스턴스는 한 번만 생성.
 * 간단한 카운팅 기능(increase(), getCount())를 갖는다.
 *
 *
 * 의문
 * 동시성 이슈는 테스트 코드에서 확인할 수 없는가?
 * -> 다른 툴을 통해 찾아야 할 듯.
 * -> 예전에 cc -fsanitize=thread(맞나?)로 data condition 체크했던 것 처럼?
 */
public class CounterServiceTest {

    @BeforeEach
    void reset_counter_viaReflection() throws Exception {
        Field cnt = CounterService.class.getDeclaredField("count");
        cnt.setAccessible(true);

        AtomicInteger count = (AtomicInteger) cnt.get(CounterService.INSTANCE);
        count.set(0);
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
