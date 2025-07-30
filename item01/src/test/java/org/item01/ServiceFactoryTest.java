package org.item01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.security.Provider.Service;

import org.junit.jupiter.api.Test;

/**
 * ServiceFactory.create()를 호출하면 Service 인터페이스를 구현한 ServiceImpl 객체 반환
 * Service에 execute() 메서드를 두고, 호출 시 간단히 텍스트 출력
 */
public class ServiceFactoryTest {

    @Test
    void create_shouldReturnNonNullService() {
        Service svc = ServiceFactory.create();
        assertNotNull(svc, "ServiceFactory.create()는 null을 반환하면 안 된다");
    }

    @Test
    void create_shouldReturnServiceImplInstacne() {
        Service svc = ServiceFactory.create();
        // private inner 클래스라도 getClass().getSimpleName()으로 확인
        assertEquals("ServiceImpl", svc.getClass().getSimpleName());
    }

}
