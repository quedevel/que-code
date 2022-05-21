# 🔥 [ Chapter7 ] 람다와 스트림

## 🎯  아이템 42. 익명 클래스보다는 람다를 사용하라.
예전에는 자바에서 함수 타입을 표현할 때 추상 메서드를 하나만 담은 인터페이스를 사용했다.<br>
이런 인터페이스의 인스턴스를 함수객체라고 하여, 특정 함수나 동작을 나타내는 데 썼다.<br>

<br>

* 익명 클래스의 인스턴스를 함수 객체로 사용 - 낡은 기법이다!
```java
public class Item43 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("test3");
        list.add("te2st3");
        list.add("test4");
        list.add("5test3");
        
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        list.forEach(System.out::println);
    }
}
```
전략 패턴처럼, 함수 객체를 사용하는 과거 객체 지향 디자인 패턴에는 익명 클래스면 충분했다.

<br>

자바8에 와서 추상 메서드 하나짜리 인터페이스는 특별한 의미를 인정받아 특별한 대우를 받게 되었다.<br>
지금은 함수형 인터페이스라 부르는 이 인터페이스들의 인스턴스를 람다식을 사용해 만들 수 있게 된 것이다.<br>

<br>

* 람다식을 함수 객체로 사용 - 익명 클래스 대체
```java
public class Item43 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("test3");
        list.add("te2st3");
        list.add("test4");
        list.add("5test3");

        // 1
        Collections.sort(list, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        
        // 2
        Collections.sort(list, comparingInt(String::length));
        
        // 3 
        list.sort(comparingInt(String::length));

        list.forEach(System.out::println);
    }
}
```
**_타입을 명시해야 코드가 더 명확할 때만 제외하고는, 람다의 모든 매개변수 타입은 생략하자._** <br>

<br>

> 람다는 이름이 없고 문서화도 못한다. 따라서 코드 자체로 동작이 명확히 설명되지 않거나 코드 줄 수가 많아지면 람다를 쓰지 말아야 한다. <br>

<br>

## 🎯  아이템 43. 람다보다는 메서드 참조를 사용하라.
## 🎯  아이템 44. 표준 함수형 인터페이스를 사용하라.
## 🎯  아이템 45. 스트림은 주의해서 사용하라.
## 🎯  아이템 46. 스트림에서는 부작용 없는 함수를 사용하라.
## 🎯  아이템 47. 반환 타입으로는 스트림보다 컬렉션이 낫다.
## 🎯  아이템 48. 스트림 병렬화는 주의해서 적용하라.

<br>

> Joshua Bloch, 『Effective Java 3/E』, 개앞맵시 옮김, 프로그래밍인사이트(2018), p207-251.