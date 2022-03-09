package com.quecode.chapter6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 6.1 Stream
 * 6.2 Filter
 * 6.3 Map
 * 6.4 Stream의 구성 요소
 * 6.5 데이터 정렬
 * 6.6 중복제거
 * 6.7 FlatMap
 */
public class Chapter6 {

    public static void main(String[] args) {
        /**
         * 6.1 Stream
         */
        Stream<String> nameStream = Stream.of("Alice", "Bob", "Charlie");
        List<String> names = nameStream.collect(Collectors.toList());
        System.out.println("names = " + names);

        String[] cityArray = new String[]{"San Jose", "Seoul", "Tokyo"};
        Stream<String> cityStream = Arrays.stream(cityArray);
        List<String> cityList = cityStream.collect(Collectors.toList());
        System.out.println("cityList = " + cityList);

        Set<Integer> numberSet = new HashSet<>(Arrays.asList(3,5,7));
        Stream<Integer> numberStream = numberSet.stream();
        List<Integer> numberList = numberStream.collect(Collectors.toList());
        System.out.println("numberList = " + numberList);

    }
}
