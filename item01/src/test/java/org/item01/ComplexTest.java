package org.item01;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.lang.Math;

/**
 * 목표 정의
 * 복소수(Complex number)를 생성하는 두 개의 정적 팩터리 메서드
 * 1. fromCartesian(re, im)
 * 2. fromPolar(r, th)
 */
public class ComplexTest {
    @Test
    void fromCartesian_setsRealAndImag() {
        Complex c = Complex.fromCartesian(1.0, 2.0);
        assertAll("cartesian",
                () -> assertEquals(1.0, c.getReal()),
                () -> assertEquals(2.0, c.getImag()));
    }

    @Test
    void fromPolar_convertsToCartesian() {
        Complex c = Complex.fromPolar(2.0, Math.PI / 2);
        assertAll("polar",
                () -> assertEquals(0.0, c.getReal(), 1e-6),
                () -> assertEquals(2.0, c.getImag(), 1e-6));
    }
}
