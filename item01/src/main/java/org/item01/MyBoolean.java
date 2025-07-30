package org.item01;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MyBoolean {

    private final boolean value;

    public static MyBoolean valueOf(boolean b) {
        return new MyBoolean(b);
    }

    public boolean booleanValue() {
        return value;
    }

}
