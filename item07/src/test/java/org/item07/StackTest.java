package org.item07;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.lang.reflect.Field;

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

    @Test
    void pop_should_null_out_obsolete_reference() throws Exception {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");

        String poped = stack.pop();
        assertEquals("B", poped);

        Field elementsField = Stack.class.getDeclaredField("elements");
        elementsField.setAccessible(true);
        Object[] elems = (Object[]) elementsField.get(stack);

        assertNull(elems[1], "pop 후 obsolete 참조를 null 처리해야 한다");
    }
}
