package com.quecode.chapter2;

/**
 * Description
 * 3. private생성자나 열거 타입으로 싱글턴임을 보증하라.
 *
 * 핵심 정리
 * 무상태 객체일때 !! 중요!!
 */
public class Item3 {

    static class Singleton {

        // LazyHolder Singleton pattern
        private Singleton(){};

        private static class LazyHolder{
            public static final Singleton instance = new Singleton();
        }

        // getInstance()를 호출했을때 LazyHolder 클래스가 로딩되면서 생성
        // 장점 : 객체가 필요한 시점에서 초기화가 진행된다.
        public static Singleton getInstance(){
            return LazyHolder.instance;
        }
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println(singleton1 == singleton2);

    }
}
