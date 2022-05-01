package com.quecode.chapter5;

import java.util.ArrayList;
import java.util.List;

public class Item26 {
    public static void main(String[] args) {
        // 로 타입 리스트
        List rawTypeList = new ArrayList();

        rawTypeList.add("raw type list");
        rawTypeList.add("quedevel");
        // 실수로 string 리스트에 int를 넣는다.
        // 여기서 int를 꺼내기전에 오류를 알 수 없다.
        rawTypeList.add(1);
        rawTypeList.add("innotree");

        // 하지만 실행하게 된다면
        rawTypeList.forEach(e -> {
            String temp = (String) e; // java.lang.ClassCastException !! 발생
            System.out.println(temp);
        });

    }
}
