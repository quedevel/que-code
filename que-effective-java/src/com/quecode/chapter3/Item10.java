package com.quecode.chapter3;

/**
 * Description
 * 10. equals는 일반 규약을 지켜 재정의하라
 *
 * 경험상 equals를 재정의한적은 없다.
 * 하지만 필요한 상황이 온다면 반드시 Object 명세에 적힌 규약을 만족시켜야한다.
 *
 * 반사성 : null이 아닌 모든 참조 값 x에 대해, x.equals(x)는 true다.
 * 대칭성 : null이 아닌 모든 참조 값 x,y에 대해, x.equals(y)가 true면 y.equals(x)도 true다.
 * 추이성 : null이 아닌 모든 참조 값 x,y,z에 대해, x.equals(y)가 true이고 y.equals(z)도 true면 x.equals(z)도 true다.
 * 일관성 : null이 아닌 모든 참조 값 x,y에 대해, x.equals(y)를 반복해서 호출하면 항상 true를 반환하거나 항상 false를 반환한다.
 * null-아님 : null이 아닌 모든 참조 값 x에 대해, x.equals(null)은 false다.
 *
 * equals 규약을 어기면 그 객체를 사용하는 다른 객체들이 어떠허게 반응할지 알 수 없다.
 * 클래스가 불변이든 가변이든 equals의 판단에 신뢰할 수 없는 자원이 끼어들게 해서는 안된다.
 *
 * equals 구현 방법을 단계별로 정리
 * 1. == 연산자를 사용해 입력이 자기 자신의 참조인지 확인한다.
 * 2. instanceof 연산자로 입력이 올바른 타입인지 확인한다.
 * 3. 입력을 올바른 타입으로 형변환한다.
 * 4. 입력 객체와 자기 자신의 대응되는 '핵심' 필드들이 모두 일치하는지 하나씩 검사한다.
 *
 * but,
 * float와 double을 제외한 기본 타입 필드는 == 연산자로 비교하고, 참조 타입 필드는
 * 각각의 equals 메서드로, float와 double 필드는 각각 정적 메서드인 Float.compare(float, float)와
 * Double.compare(double, double)로 비교한다.
 */
public class Item10 {

    public static void main(String[] args) {

        String x = "Effective Java 3/E", y = "Effective Java 3/E", z = "Effective Java 3/E";

        System.out.println("반사성 : null이 아닌 모든 참조 값 x에 대해, x.equals(x)는 "+x.equals(x)+"다.");
        System.out.println("대칭성 : null이 아닌 모든 참조 값 x,y에 대해, x.equals(y)가 "+x.equals(y)+" y.equals(x)도 "+y.equals(x)+"다.");
        System.out.println("추이성 : null이 아닌 모든 참조 값 x,y,z에 대해, " +
                "x.equals(y)가 "+x.equals(y)+"이고 y.equals(z)도 "+y.equals(z)+"면 x.equals(z)도 "+x.equals(z)+"다.");
        System.out.println("null-아님 : null이 아닌 모든 참조 값 x에 대해, x.equals(null)은 "+x.equals(null)+"다.");


    }
}
