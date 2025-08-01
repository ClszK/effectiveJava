package org.item05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import lombok.Getter;

class PaymentServiceTest {
    @Test
    void processPayment_withValidAmountInvokesGateway() {
        var fakeGateway = new FakePaymentGateway();
        var service = new PaymentService(fakeGateway);

        service.processPayment(5_000);

        assertEquals(5_000, fakeGateway.getLastChargedAmount());
        assertEquals(1, fakeGateway.getInvokeCount());
    }

    @Getter
    static class FakePaymentGateway implements PaymentGateway {
        private int lastChargedAmount;
        private int invokeCount;

        @Override
        public void charge(int amount) {
            lastChargedAmount = amount;
            ++invokeCount;
        }
    }
}
