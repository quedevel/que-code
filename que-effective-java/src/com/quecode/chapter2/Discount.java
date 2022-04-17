package com.quecode.chapter2;

public abstract class Discount {
    public static <E extends Discount> Discount getInstance(String code){
        return code.equals("1")? new RateDiscount() : new FixedDiscount();
    }
}
