package org.item05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lombok.Getter;

/**
 * 결제 처리(PaymentServcie) 시나리오, 외부 결제 게이트웨이(PaymentGateway)를 생성자 주입
 */
class PaymentServiceTest {
    @Test
    void processPayment_withValidAmountInvokesGateway() {
        var fakeGateway = new FakePaymentGateway();
        var service = new PaymentService(fakeGateway);

        service.processPayment(5_000);

        assertEquals(5_000, fakeGateway.getLastChargedAmount());
        assertEquals(1, fakeGateway.getInvokeCount());
    }

    @ParameterizedTest(name = "[{index}] amount = {0}")
    @ValueSource(ints = { 0, -1_000 })
    void processPayment_invalidAmount_throwsIllegalArgumentException(int invalidAmount) {
        var fakeGateway = new FakePaymentGateway();
        var service = new PaymentService(fakeGateway);

        assertThrows(IllegalArgumentException.class,
                () -> service.processPayment(invalidAmount));
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
