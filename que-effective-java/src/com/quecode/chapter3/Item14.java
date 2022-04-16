package com.quecode.chapter3;

/**
 * Description
 * 14. Comparable을 구현할지 고려하라.
 * <p>
 * 순서를 고려해야 하는 값 클래스를 작성한다면 꼭 Comparable 인터페이스를 구현하여,
 * 그 인스턴스들을 쉽게 정렬하고, 검색하고, 비교 기능을 제공하는 컬렉션과 어우러지도록
 * 해야 한다. compareTo 메서드에서 필드의 값을 비교할 때 <와 > 연산자는 쓰지 말아야 한다.
 * 그 대신 박싱된 기본 타입 클래스가 제공하는 정적 compare 메서드난 Comparator 인터페이스가
 * 제공하는 비교자 생성 메서드를 사용하자.
 */
public class Item14 implements Comparable<Item14> {

    private Integer integer;

    public Item14(Integer integer) {
        this.integer = integer;
    }

    @Override
    public int compareTo(Item14 o) {
        return Integer.compare(integer, o.integer);
    }

    public static void main(String[] args) {
        Item14 item = new Item14(3);
        Item14 item2 = new Item14(1);
        Item14 item3 = new Item14(5);
        Item14 item4 = new Item14(3);
        System.out.println(item.compareTo(item2)); // 1
        System.out.println(item.compareTo(item3)); // -1
        System.out.println(item.compareTo(item4)); // 0
    }
}
