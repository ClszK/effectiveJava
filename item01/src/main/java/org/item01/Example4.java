package org.item01;

import lombok.Builder;

interface NumberWrapper {
    void print();
}

@Builder
class IntegerWrapper implements NumberWrapper {
    private final int value;

    public IntegerWrapper(int value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.println("IntegerWrapper: " + value);
    }
}

class DoubleWrapper implements NumberWrapper {
    private final double value;

    public DoubleWrapper(double value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.println("DoubleWrapper: " + value);
    }
}

/**
 * 입력 매개변수에 따라 다른 클래스의 객체를 반환하기
 */
public class Example4 {

}