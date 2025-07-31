package org.item01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * ServiceFactoryDynamic.load(String implClassName)
 * - 주어진 클래스 이름으로 MyService 구현체를 인스턴스화하여 반환
 * - 없는 클래스 이름일 경우 RuntimeException 발생
 */
public class ServiceFactoryDynamicTest {

    @Test
    void load_knownImplShouldReturnInstance() {
        MyService svc = ServiceFactoryDynamic.load("MyServiceImpl");
        assertNotNull(svc);
        assertEquals("MyServiceImpl", svc.getClass().getSimpleName());
    }

    @Test
    void load_unknownImplShouldThrow() {
        assertThrows(RuntimeException.class,
                () -> ServiceFactoryDynamic.load("NonExistentService"));
    }

}
