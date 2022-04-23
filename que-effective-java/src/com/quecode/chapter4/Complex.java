package com.quecode.chapter4;

// class를 final로 선언하여 확장할 수 없도록 함
public final class Complex {
    // 모든 필드를 private final로 선언
    private final double re;
    private final double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    // getter만 존재 setter는 만들지 않는다.
    public double getRe() { return re; }
    public double getIm() { return im; }

    public Complex plus(Complex complex) { return new Complex(re + complex.re, im + complex.im); }
}
