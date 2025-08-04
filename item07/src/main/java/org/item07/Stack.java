package org.item07;

import java.util.Arrays;

public class Stack<E> {
    private Object[] elements = new Object[10];
    private int size = 0;

    public void push(E e) {
        if (size == elements.length) {
            int newCap = elements.length * 2;
            elements = Arrays.copyOf(elements, newCap);
        }
        elements[size++] = e;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        int idx = --size;
        if (idx < 0)
            throw new IllegalArgumentException("stack size is 0");
        Object elem = elements[idx];
        elements[idx] = null;
        return (E) elem;
    }
}
