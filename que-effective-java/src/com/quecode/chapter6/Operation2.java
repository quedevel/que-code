package com.quecode.chapter6;

public enum Operation2 {
    PLUS { public double apply(double x, double y){ return x+y; } },
    MINUS { public double apply(double x, double y){ return x-y; } },
    TIMES { public double apply(double x, double y){ return x*y; } },
    DIVIDE { public double apply(double x, double y){ return x/y; } };

    public abstract double apply(double x, double y); // 추상 메서드를 선언
}
