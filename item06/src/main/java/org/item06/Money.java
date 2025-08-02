package org.item06;

import java.util.Objects;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Money {
    private final String currency;
    private final int amount;

    public static Money of(String currency, int amount) {
        return new Money(currency, amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Money))
            return false;
        Money that = (Money) o;
        return amount == that.amount
                && currency.equals(that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }
}
