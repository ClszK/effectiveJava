package org.item03;

public enum UniqueIdGenerator{
    INSTANCE;

    private long id = 0;

    Long generate() {
        return ++id;
    }

}
