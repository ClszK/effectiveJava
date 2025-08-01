package org.item05;

/**
 * 외부 결제 시스템을 추상화한 인터페이스.
 * <ul>
 *  <li>charge(int amount) : 주어진 금액만큼 결제 요청 전송.</li>
 * </ul>
 */
public interface PaymentGateway {

    void charge(int amount);

}
