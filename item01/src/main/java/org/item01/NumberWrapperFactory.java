package org.item01;

public class NumberWrapperFactory {

    public static NumberWrapper of(Number n) {
        return new IntegerWrapper(n.intValue());
    }
}
