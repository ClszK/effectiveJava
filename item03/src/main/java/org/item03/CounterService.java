package org.item03;

import lombok.Getter;

@Getter
public class CounterService {

    public static final CounterService INSTANCE = new CounterService();
    private int count = 0;

    private CounterService() { }

    public int increase() {
        return ++count;
    }

    void reset() {
        count = 0;
    }
}
