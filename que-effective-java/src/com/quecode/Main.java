package com.quecode;

import com.quecode.chapter2.Discount;

public class Main {
    public static void main(String[] args) {
        Discount instance = Discount.getInstance("1");
        //com.quecode.chapter2.RateDiscount@2133c8f8
        System.out.println(instance);
    }
}
