package org.item05;

import lombok.RequiredArgsConstructor;

/**
 * 결제 처리를 담당하는 서비스
 */
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentGateway gateway;

    /**
     * amount 만큼 결제 요청을 위임.
     * @param amount 청구할 금액(원 단위)
     */
    public void processPayment(int amount) {
        gateway.charge(amount);
    }
}
