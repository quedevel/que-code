package com.quecode.chapter5;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 4.1 Method Reference
 * 4.2 Method Reference 2
 * 4.3 Constructor Reference
 */
public class Chapter5 {

    public static void main(String[] args) {

        /**
         * 4.1 Method Reference
         */
        Function<String, Integer> str2int = Integer::parseInt;
        System.out.println("str2int = " + str2int.apply("20"));

        String str = "Hell";
        Predicate<String> equalsToHell = str::equals;
        System.out.println("equalsToHell = " + equalsToHell.test(str));

        System.out.println(calculate(8,2,(x,y)-> x+y));

        // static method
        System.out.println(calculate(8,2,Chapter5::multiply));

        // instance method
        Chapter5 chapter5 = new Chapter5();
        System.out.println(calculate(8,2,chapter5::subtract));
        chapter5.myMethod();

        System.out.println();
        System.out.println();

        /**
         * 4.1 Method Reference 2
         */
    }

    public static int calculate(int x, int y, BiFunction<Integer, Integer, Integer> operator){
        return operator.apply(x,y);
    }

    public static int multiply(int x, int y){
        return x * y;
    }

    public int subtract(int x, int y){
        return x - y;
    }

    public void myMethod(){
        System.out.println(calculate(10,3,this::subtract));
    }
}
