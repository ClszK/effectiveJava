package org.item07;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.ref.WeakReference;
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

    @Test
    void pop_should_allow_gc_of_popped_elements() {
        Stack<Object> stack = new Stack<>();
        Object obj = new Object();
        WeakReference<Object> weakRef = new WeakReference<>(obj);

        stack.push(obj);
        obj = null; // strong reference 제거

        System.gc();
        assertNotNull(weakRef.get());

        stack.pop(); // obsolete reference 해제

        System.gc();
        assertNull(weakRef.get());
    }

    @Test
    void pop_on_empty_stack_should_throw() {
        Stack<String> stack = new Stack<>();
        assertThrows(IllegalArgumentException.class, stack::pop);
    }

    @Test
    void push_beyond_initial_capacity_should_expand_array() throws Exception {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 20; ++i)
            stack.push(i);

        Field elementsField = Stack.class.getDeclaredField("elements");
        elementsField.setAccessible(true);
        Object[] elems = (Object[]) elementsField.get(stack);

        assertTrue(elems.length >= 20, "용량이 자동 확장되어야 함");
    }
}
