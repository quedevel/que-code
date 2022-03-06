package com.quecode.chapter4;

import java.util.function.Supplier;

/**
 * 4.1 Supplier
 * 4.2 Consumer
 * 4.3 BiConsumer
 * 4.4 Predicate
 * 4.5 Comparator
 */
public class Chapter4 {

    public static void main(String[] args) {

        /**
         * 4.1 Supplier
         */
        Supplier<String> supplier = () -> "hello world";
        System.out.println("supplier = " + supplier.get());

        Supplier<Double> doubleSupplier = () -> Math.random();
        System.out.println("doubleSupplier = " + doubleSupplier.get());

        printRandomDoubles(doubleSupplier, 5);

        /**
         * 4.2 Consumer
         */

    }

    public static void printRandomDoubles(Supplier<Double> randomSupplier, int count){
        for (int i = 0; i < count; i++){
            System.out.println(randomSupplier.get());
        }
    }
}
