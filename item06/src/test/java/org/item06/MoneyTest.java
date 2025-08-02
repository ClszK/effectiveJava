package org.item06;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void of_same_currency_and_amount_should_return_same_instance() {
        Money m1 = Money.of("USD", 10);
        Money m2 = Money.of("USD", 10);

        assertSame(m1, m2);
    }

    @Test
    void of_sould_handle_multiple_currencies_and_amounts() {
        Money usd10 = Money.of("USD", 10);
        Money eur10 = Money.of("EUR", 10);

        assertNotSame(usd10, eur10);
    }

    @Test
    void of_null_or_blank_currency_should_throw() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> Money.of(null, 10)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> Money.of("", 10)));
    }

    @Test
    void of_negative_amount_should_throw() {
        assertThrows(IllegalArgumentException.class,
                () -> Money.of("USD", -1));
    }

    @Test
    void of_amount_above_cache_limit_should_return_different_instances() {
        int limit = Money.MAX_CACHED_AMOUNT;
        Money m1 = Money.of("USD", limit + 1);
        Money m2 = Money.of("USD", limit + 1);

        assertNotSame(m1, m2);
    }
}
