package com.quecode.chapter2;

/**
 * Description
 * 6. 불필요한 객체 생성을 피하라.
 *
 * 핵심 정리
 * 제목 그대로 불필요한 객체 생성을 피하고
 * 박싱된 기본타입보단 기본 타입을 사용하자
 */
public class Item6 {
    public static void main(String[] args) {
        // 끔찍하게 느린 박싱타입 계산
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
