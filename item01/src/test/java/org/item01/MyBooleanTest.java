package org.item01;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * MyBoolean.valueOf(boolean)을 호출하면
 * true -> 항상 같은 MyBoolean.TRUE 인스턴스 반환
 * false -> 항상 같은 MyBoolean.FALSE 인스턴스 반환
 * booleanValue()로 내부 원시 boolean 값을 꺼낼 수 있어야 함
 */
public class MyBooleanTest {
    @Test
    void booleanValue_returnsCorrectPrimitive() {
        MyBoolean t = MyBoolean.valueOf(true);
        MyBoolean f = MyBoolean.valueOf(false);
        assertTrue(t.booleanValue());
        assertFalse(f.booleanValue());
    }

    @Test
    void valueOf_trueReturnsSameInstacne() {
        var b1 = MyBoolean.valueOf(true);
        var b2 = MyBoolean.valueOf(true);
        assertSame(b1, b2);
    }

    @Test
    void valueOf_falseReturnsSameInstacne() {
        var b1 = MyBoolean.valueOf(false);
        var b2 = MyBoolean.valueOf(false);
        assertSame(b1, b2);
    }
}
