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
결과적으로, 로 타입을 쓰면 제네릭이 안겨주는 안정성과 표현력을 모두 잃게 된다.<br>

<br>

그럼에도 로 타입을 쓰지 말라는 규칙에도 소소한 예외가 몇 개 있다.
1. **class 리터럴에는 로 타입을 써야 한다.**<br>
ex) List.class, String[].class, int.class는 허용하고 List<String>.class와 List<?>.class는 허용하지 않는다.<br>

2. **instanceof 연산자와 관련이 있다. 런타임에는 제네릭 타입 정보가 지워지므로 instanceof 연산자는 비한정적 와일드카드 타입 이외의 매개변수화 타입에는 적용할 수 없다.**<br>
```java
if(o instanceof Set){
    Set<?> s = (Set<?>) o;    
}
```
> o의 타입이 Set임을 확인한 다음 와일드카드 타입인 Set<?>로 형변환해야 한다. 이는 검사 형변환(checked cast)이므로 컴파일 경고가 뜨지 않는다.

## 🎯  아이템 27. 비검사 경고를 제거하라.
* 비검사 경고
![캡처5](https://user-images.githubusercontent.com/55771326/166133559-1297d608-d80b-4543-82ca-15aeac1fc99e.PNG)
* 결과 : <br>
![캡처4](https://user-images.githubusercontent.com/55771326/166133532-40bd2533-70f6-4ddc-b828-77ac15e34564.PNG)
위 처럼 영역이 하이라이트로 경고를 보여주는데 이를 비검사 경고라고 한다. <br>
이러한 경고들은 할 수 있는 한 모두 제거하도록 하자.
* 컴파일러가 알려준 대로 수정 ( 다이아몬드 연산자만으로 해결 )
![캡처6](https://user-images.githubusercontent.com/55771326/166133608-8d1559ae-8762-4fc0-83a2-16adabe05e9d.PNG)

<br>

but. 경고를 제거할 수는 없지만 타입 안전하다고 확신할 수 있다면 `@SuppressWarnings("unchecked")` 애너테이션을 달아 경고를 숨기자.
```java
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
@Retention(RetentionPolicy.SOURCE)
public @interface SuppressWarnings {
    ...
}
```
⭐ `@SuppressWarnings` 애너테이션은 항상 가능한 한 좁은 범위에 적용하자.

* `@SuppressWarnings` 사용한 소스
```java
public class Item27 {
    public static void main(String[] args) {
        // 무시해도 안전한 이유를 주석으로 남겨라!
        @SuppressWarnings("unchecked") Set<Member> set = new HashSet();
    }
}
```
⭐ `@SuppressWarnings` 애너테이션을 사용할 때면 그 경고를 무시해도 안전한 이유를 항상 주석으로 남겨야 한다.

## 🎯  아이템 28. 

## 🎯  아이템 29. 

## ⭐ 결론