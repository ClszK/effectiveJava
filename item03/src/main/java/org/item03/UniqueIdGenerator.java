package org.item03;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 애플리케이션 전역 고유 ID 생성기.
 * <p>
 * 열거 타입 싱글턴 방식으로 구현.
 * 멀티스레드 환경에서도 안전하게 동작하도록 내부에 AtomicLong 카운터를 사용.
* </p>
* <ul>
*   <li>generate() : 호출할 때마다 1씩 증가한 고유 ID를 반환 (initial value : 1)</li>
* </ul>
*
*/
public enum UniqueIdGenerator {
    INSTANCE;

    private final AtomicLong id = new AtomicLong(0L);

    Long generate() {
        return id.incrementAndGet();
    }
}
