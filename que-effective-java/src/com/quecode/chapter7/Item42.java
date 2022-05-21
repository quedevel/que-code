package com.quecode.chapter7;

import java.util.*;

import static java.util.Comparator.comparingInt;

public class Item42 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("test3");
        list.add("te2st3");
        list.add("test4");
        list.add("5test3");

        Collections.sort(list, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        Collections.sort(list, comparingInt(String::length));

        list.sort(comparingInt(String::length));

        list.forEach(System.out::println);
    }
}
