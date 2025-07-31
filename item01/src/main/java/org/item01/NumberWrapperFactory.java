package org.item01;

public class NumberWrapperFactory {

    public static NumberWrapper of(Number n) {
        if (n instanceof Integer)
            return new IntegerWrapper(n.intValue());
        else if (n instanceof Double)
            return new DoubleWrapper(n.doubleValue());
        throw new IllegalArgumentException();
    }
}
