package org.item07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StackTest {

    @Test
    void push_and_pop_should_follow_LIFO_order() {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");

        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
    }
}
