package org.item05;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StripePaymentGateway implements PaymentGateway {
    private final String apiKey;

    @Override
    public void charge(int amount) {
        System.out.printf("Stripe에 %d원 청구 (API_KEY = %s)%n", amount, apiKey);
    }

}
