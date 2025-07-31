package org.item01;

public class NumberWrapperFactory {

    public static NumberWrapper of(Number n) {
        return switch (n) {
            case Integer i -> new IntegerWrapper(i);
            case Double d -> new DoubleWrapper(d);
            default ->
                throw new IllegalArgumentException(
                        "Unsupported type: " + n.getClass().getSimpleName());
        };
    }
}
