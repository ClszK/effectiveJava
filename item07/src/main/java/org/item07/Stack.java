package org.item07;

public class Stack<E> {
    private final Object[] elements = new Object[10];
    private int size = 0;

    public void push(E e) {
        elements[size++] = e;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        Object elem = elements[--size];
        elements[size] = null;
        return (E) elem;
    }

}
