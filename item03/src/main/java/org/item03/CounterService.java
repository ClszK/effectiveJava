package org.item03;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterService {

    public static final CounterService INSTANCE = new CounterService();
    private final AtomicInteger count = new AtomicInteger(0);

    private CounterService() { }

    public int increase() {
        return count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
