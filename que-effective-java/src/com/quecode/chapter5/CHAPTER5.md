# 🔥 [ Chapter5 ] 제네릭

## 🎯  아이템 26. 로 타입은 사용하지 말라
클래스와 인터페이스 선언에 타입 매개변수가 쓰이면, 이를 제네릭 클래스 혹은 제네릭 인터페이스라 한다.
* 제네릭 클래스
```java
public class ArrayList<E> extends AbstractList<E> 
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable { 
    ... 
}
```
* 제네릭 인터페이스
```java
public interface List<E> extends Collection<E> { ... }
```
제네릭 클래스와 제네릭 인터페이스를 통틀어 제네릭 타입(generic type)이라 한다.<br>
각각의 제네릭 타입은 일련의 매개변수화 타입(parameterized type)을 정의한다.<br>
제네릭 타입을 하나 정의하면 그에 딸린 로 타입(raw type)도 함께 정의된다.
로 타입이란 제네릭 타입에서 타입 매개변수를 전혀 사용하지 않을 때를 말한다.
* 로 타입
```java
public class Item26 {
    public static void main(String[] args) {
        // 제네릭 타입 리스트
        List<String> genericTypeList = new ArrayList<>();
        // 로 타입 리스트
        List rawTypeList = new ArrayList();
    }
}
```

* 로 타입의 문제점
```java
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
```
다른 타입의 값을 넣어줘도 컴파일시에는 발견되지 않다가 런타임에야 알아챌 수 있다. 이상적으로는 컴파일할 때 발견하는 것이 좋다.<br>
결과적으로, 로 타입을 쓰면 제네릭이 안겨주는 안정성과 표현력을 모두 잃게 된다.
## ⭐ 결론