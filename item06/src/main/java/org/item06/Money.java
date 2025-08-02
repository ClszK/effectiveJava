package org.item06;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Money {
    public static final int MAX_CACHED_AMOUNT = 1_000;

    private static final Map<String, Map<Integer, Money>> CACHE = new ConcurrentHashMap<>();

    private final String currency;
    private final int amount;

    public static Money of(String currency, int amount) {
        if (currency == null || currency.isBlank())
            throw new IllegalArgumentException("currency는 null이거나 비어있으면 안된다.");
        if (amount < 0)
            throw new IllegalArgumentException("amount는 음수면 안된다.");

        if (amount <= MAX_CACHED_AMOUNT) {
            return CACHE
                    .computeIfAbsent(currency, c -> new ConcurrentHashMap<>())
                    .computeIfAbsent(amount, a -> new Money(currency, a));
        }
        return new Money(currency, amount);
    }
}
