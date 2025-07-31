package org.item01;

public class NumberWrapperFactory {

    public static NumberWrapper of(Number n) {
        if (n instanceof Integer)
            return new IntegerWrapper(n.intValue());
        return new DoubleWrapper(n.doubleValue());
    }
}
