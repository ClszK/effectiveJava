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
    private static final Map<String, Map<Integer, Money>> CACHE = new ConcurrentHashMap<>();

    private final String currency;
    private final int amount;

    public static Money of(String currency, int amount) {
        return CACHE
                .computeIfAbsent(currency, c -> new ConcurrentHashMap<>())
                .computeIfAbsent(amount, a -> new Money(currency, a));
    }
}
