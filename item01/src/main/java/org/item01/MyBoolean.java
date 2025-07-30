package org.item01;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MyBoolean {

    private static final MyBoolean TRUE = new MyBoolean(true);
    private static final MyBoolean FALSE = new MyBoolean(false);

    private final boolean value;

    public static MyBoolean valueOf(boolean b) {
        return b ? TRUE : FALSE;
    }

    public boolean booleanValue() {
        return value;
    }

}
