package com.quecode.chapter7;

import java.io.IOException;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class StreamAnagrams {
    public static void main(String[] args) throws IOException {
        int minGroupSize = Integer.parseInt("1");
        Stream<String> words = Stream.of("abc","euq","test","zzfq","que","acb");

        words.collect(
                        groupingBy(word -> word.chars().sorted()
                                .collect(StringBuilder::new,
                                        (sb, c) -> sb.append((char) c),
                                        StringBuilder::append).toString()))
                .values().stream()
                .filter(group -> group.size() >= minGroupSize)
                .map(group -> group.size() + ": " + group)
                .forEach(System.out::println);
    }
}
