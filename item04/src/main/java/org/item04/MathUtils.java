package org.item04;

/**
 * Math 유틸리티 클래스
* <p>
* 기본 생성자 private
* final 선언으로 상속 불가
* </p>
* <ul>
*   <li>isPrime() : 현재 소수인지 아닌지 판별</li>
* </ul>
*
*/
public final class MathUtils {

    private MathUtils() { }

    public static boolean isPrime(long n) {
        if (n < 2)
            return false;
        for (long i = 2; i <= Math.sqrt(n); ++i) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
