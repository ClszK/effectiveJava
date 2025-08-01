package org.item05;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 결제 처리를 담당하는 서비스
 */
@RequiredArgsConstructor
public class PaymentService {
    @NonNull
    private final PaymentGateway gateway;

    /**
     * amount 만큼 결제 요청을 위임.
     * 
     * @param amount 청구할 금액(원 단위)
     * @thorws IllegalArgumentException amount가 0이하일 때
     */
    public void processPayment(int amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("amount는 양수여야 한다.");
        gateway.charge(amount);
    }
}
