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

    @Test
    void equals_should_be_true_for_same_currency_and_amount() {
        Money m1 = Money.of("USD", 10);
        Money m2 = Money.of("USD", 10);

        assertEquals(m1, m2);
        assertEquals(m1.hashCode(), m2.hashCode());
    }
}
