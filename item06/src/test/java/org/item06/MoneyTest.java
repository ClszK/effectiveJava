package org.item06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void of_should_create_money() {
        Money m = Money.of("USD", 10);

        assertEquals("USD", m.getCurrency());
        assertEquals(10, m.getAmount());
    }
}
