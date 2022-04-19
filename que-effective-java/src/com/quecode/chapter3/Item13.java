package com.quecode.chapter3;

/**
 * Description
 * 13. clone 재정의는 주의해서 진행하라
 *
 * Cloneable이 몰고 온 모든 문제를 되짚어봤을 때, 새로운 인터페이스를 만들 때는 절대 Cloneable을 확장해서는 안되며,
 * 새로운 클래스도 이를 구현해서는 안 된다. final 클래스라면 Cloneable을 구현해도 위험이 크지 않지만,
 * 성능 최적화 관점에서 검토한 후 별다른 문제가 없을 때만 드믈게 허용해야 한다. 기본 원칙을 '복제 기능은 생성자와 팩터리를
 * 이용하는 게 최고'라는 것이다. 단, 배열만은 clone 메서드 방식이 가장 깔끔한, 이 규칙의 합당한 예외라 할 수 있다.
 */
public class Item13 implements Cloneable{
    int num;

    public Item13() {
        System.out.println("---------------------");
        System.out.println("Item13 constructor");
        System.out.println("---------------------");
    }

    public Item13(int num) {
        System.out.println("---------------------");
        System.out.println("Item13 constructor");
        System.out.println("---------------------");
        this.num = num;
    }

    @Override
    public Item13 clone() {
        try {
            return (Item13) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        Item13 item13 = new Item13(3);
        Item13 clone = item13.clone();

        System.out.println(item13 != clone);
    }
}
