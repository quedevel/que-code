package com.quecode.chapter3;

import com.quecode.chapter3.util.Adder;

import java.util.function.Function;

/**
 *
 * 3.1 Function Interface
 * 3.2 Lambda
 * 3.3 BiFunction Interface
 * 3.4 Functional Interface
 * 
 */
public class Chapter3 {

    public static void main(String[] args) {

        Function<Integer, Integer> adder = new Adder();

        int result = adder.apply(1);

        System.out.println(result);
    }
}
