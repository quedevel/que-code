package com.quecode.chapter4;

import java.util.List;

public class Item18 {
    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("ㄱ","ㄴ","ㄷ"));
        System.out.println("s.getAddCount() : "+s.getAddCount());
    }
}
