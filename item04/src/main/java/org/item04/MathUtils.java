package org.item04;

public class MathUtils {

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
