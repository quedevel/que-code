package com.quecode.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
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

        System.out.println();
        System.out.println();
        
        /**
         * 4.2 Consumer
         */
        Consumer<String> stringConsumer = str -> System.out.println(str);
        stringConsumer.accept("Hell World");

        Consumer<Integer> integerConsumer = x -> System.out.println("Processing Integer " + x);
        List<Integer> integerList = Arrays.asList(4,2,3);

        process(integerList, integerConsumer);
        System.out.println();
        System.out.println();

        /**
         * 4.3 BiConsumer
         */
        BiConsumer<Integer, Double> doubleBiConsumer = (index, input) -> System.out.println("Processing " + input+" at index "+index);
        List<Double> doubleList = Arrays.asList(4.1,2.2,3.3);

        process(doubleList, doubleBiConsumer);
        System.out.println();
        System.out.println();

        /**
         * 4.4 Predicate
         */
        Predicate<Integer> integerPredicate = x -> x>0;
        System.out.println(integerPredicate.test(2));

        List<Integer> inputs = Arrays.asList(10,-5,-2,0,3);
        System.out.println("filter(inputs, integerPredicate) = " + filter(inputs, integerPredicate));
        System.out.println("filter(inputs, integerPredicate.negate()) = " + filter(inputs, integerPredicate.negate()));
        System.out.println("filter(inputs, integerPredicate.or(x-> x==0)) = " + filter(inputs, integerPredicate.or(x-> x==0)));
        System.out.println("filter(inputs, integerPredicate.and(x-> x%2 == 0)) = " + filter(inputs, integerPredicate.and(x-> x%2 == 0)));
        System.out.println();
        System.out.println();
    }

    public static void printRandomDoubles(Supplier<Double> randomSupplier, int count){
        for (int i = 0; i < count; i++){
            System.out.println(randomSupplier.get());
        }
    }

    public static <T> void process(List<T> inputs, Consumer<T> processor){
        for (T input : inputs){
            processor.accept(input);
        }
    }

    public static <T> void process(List<T> inputs, BiConsumer<Integer, T> processor){
        for (int i = 0; i < inputs.size(); i++) {
            processor.accept(i, inputs.get(i));
        }
    }

    public static <T> List<T> filter(List<T> inputs, Predicate<T> condition){
        List<T> output = new ArrayList<>();
        for (T t : inputs) {
            if(condition.test(t)){
                output.add(t);
            }
        }
        return output;
    }
}
