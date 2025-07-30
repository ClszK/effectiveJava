package org.item01;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Complex {

    private final double re, im;

    public static Complex fromCartesian(double re, double im) {
        return new Complex(re, im);
    }

    public static Complex fromPolar(double r, double theta) {
        double x = r * Math.cos(theta);
        double y = r * Math.sin(theta);
        return new Complex(x, y);
    }

    public double getReal() {
        return re;
    }

    public double getImag() {
        return im;
    }

}
