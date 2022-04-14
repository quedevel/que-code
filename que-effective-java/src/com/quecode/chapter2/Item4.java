package com.quecode.chapter2;

/**
 * Description
 * 4. 인스턴스화를 막으려거든 private 생성자를 사용하라.
 *
 * 핵심 정리
 * 객체 지향적으로 사고하지 않는 이들이 종종 남용하는 방식이지만 나름에 쓰임새가 있으니 고려해서 잘 활용하자
 */
public class Item4 {
    static class StringUtils {

        private StringUtils(){}

        public static boolean isEmpty(final CharSequence cs) {
            return cs == null || cs.length() == 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.isEmpty(null));      // true
        System.out.println(StringUtils.isEmpty(""));        // true
        System.out.println(StringUtils.isEmpty(" "));       // false
        System.out.println(StringUtils.isEmpty("bob"));     // false
        System.out.println(StringUtils.isEmpty("  bob  ")); // false
    }
}
