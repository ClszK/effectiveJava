package org.item06;

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
}
