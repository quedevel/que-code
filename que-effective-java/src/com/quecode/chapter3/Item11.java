package com.quecode.chapter3;

/**
 * Description
 * 11. equals를 재정의하려거든 hashCode도 재정의하라
 *
 * if. equals를 재정의
 *  반드시 hashCode도 재정의 하라.
 *
 * because.
 * HashMap, HashSet 같은 컬렉션의 원소로 사용할 때 문제를 일으킬 것이다.
 *
 * Object 명세
 *  * equals 비교에 사용되는 정보가 변경되지 않았다면, 애플리케이션이 실행되는 동안 그 객체의 hashCode 메서드는
 *    몇 번을 호출해도 일관되게 항상 같은 값을 반환해야 한다.
 *    단, 애플리케이션을 다시 실행한다면 이 값이 달라져도 상관없다.
 *  * equals(Object)가 두 객체를 같다고 판단했다면, 두 객체의 hashCode는 똑같은 값을 반환해야 한다.
 *  * equals(Object)가 두 객체를 다르다고 판단했더라도, 두 객체의 hashCode가 서로 다른 값을 반환할 필요는 없다.
 *    단, 다른 객체에 대해서는 다른 값을 반환해야 해시테이블의 성능이 좋아진다.
 */
public class Item11 {
}
