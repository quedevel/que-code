package com.quecode.chapter7;

import java.io.IOException;
import java.util.*;

public class IterativeAnagrams {
    public static void main(String[] args) throws IOException {
        String[] sArr = new String[]{"abc","euq","test","zzfq","que","acb"};
        int minGroupSize = Integer.parseInt("1");

        Map<String, Set<String>> groups = new HashMap<>();

        for (String s : sArr) {
            String word = s;
            groups.computeIfAbsent(alphabetize(word),
                    (unused) -> new TreeSet<>()).add(word);
        }

        for (Set<String> group : groups.values())
            if (group.size() >= minGroupSize)
                System.out.println(group.size() + ": " + group);
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
