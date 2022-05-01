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

## 🎯  아이템 28. 배열보다는 리스트를 사용하라.

배열과 제네릭 타입에는 중요한 차이가 두 가지 있다.

<br>

#### 1️⃣ 배열은 공변이지만, 제네릭은 불공변이다.<br>
`Sub`가 `Super`의 하위 타입이라면 배열 `Sub[]`는 배열 `Super[]`의 하위 타입이 된다. <br> 
반면, 서로 다른 타입 `Type1`, `Type2`가 있을 때, `List<Type1>`은 `List<Type2>`의 하위 타입도 아니고 상위 타입도 아니다. <br>

![캡처7](https://user-images.githubusercontent.com/55771326/166134253-7691cc3a-6272-4869-add6-6d0a508535e9.PNG)

어느 쪽이든 `Long`용 저장소에 `String`을 넣을 수는 없다. 다만 배열에서는 그 실수를 런타임에야 알게 되지만, 리스트를 사용하면 컴파일할 때 바로 알 수 있다.

<br>

#### 2️⃣ 배열은 실체화(reify)된다. <br>
배열은 런타임에도 자신이 담기로 한 원소의 타입을 인지하고 확인한다. 그래서 위 코드에 보듯 `Long`배열에 `String`을 넣으려 하면 `ArrayStoreException`이 발생한다. <br>
반면, 제네릭은 타입 정보가 런타임에는 소거(erasure)된다.

* Item28.java
```java
public class Item28 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("que");
        strings.add("devel");
    }
}
```
* Item28.java를 컴파일한 Item28.class
```java
public class Item28 {
    public Item28() {
    }

    public static void main(String[] var0) {
        ArrayList var1 = new ArrayList();
        var1.add("que");
        var1.add("devel");
    }
}
```
이러한 소거는 제네릭이 지원되기 전에 레거시 코드와 제네릭 타입을 함께 사용할 수 있게 해주는 매커니즘으로, 자바5가 제네릭으로 순조롭게 전환될 수 있도록 해줬다.

<br>

#### 배열은 제네릭 타입, 매개변수화 타입, 타입 매개변수로 사용할 수 없다.
즉, `new List<E>`, `new List<String>[]`, `new E[]` 식으로 작성하면 컴파일할 때 제네릭 배열 생성 오류를 일으킨다.<br>
그 이유는 타입 안전하지 않기 때문이다. 이를 허용한다면 컴파일러가 자동 생성한 형변환 코드에서 런타임에 `ClassCastException`이 발생할 수 잇다.

<br>

* 제네릭 배열 생성을 허용하지 않는 이유 - 컴파일되지 않는다.
```java
List<String>[] stringLists = new List<String>[1];   // (1)
List<Integer> intList = List.of(42);                // (2)
Object[] objects = stringLists;                     // (3)
objects[0] = intList;                               // (4)
String s = stringLists[0].get(0);                   // (5)
```
🚩 **if. 제네릭 배열을 생성하는 (1)이 허용된다면?** <br>
1️⃣ (2)는 원소가 하나인 `List<Integer>`를 생성한다.<br> 
2️⃣ (3)은 (1)에서 생성한 `List<String>`의 배열을 `Object` 배열에 할당한다. 배열은 공변이니 아무 문제없다. <br>
3️⃣ (4)는 (2)에서 생성한 `List<Integer>`의 인스턴스를 `Object` 배열의 첫 원소로 저장한다. 제네릭은 소거 방식으로 구현되어서 이 역시 성공한다. <br>
( 즉, 런타임에는 `List<Integer>` 인스턴스의 타입은 단순히 `List`가 되고, `List<Integer>[]` 인스턴스의 타입은 `List[]`가 된다. 따라서 (4)에서도 `ArrayStoreException`을 일으키지 않는다.) <br>
4️⃣ `List<String>` 인스턴스만 담겠다고 선언한 `stringLists`배열에는 지금 `List<Integer>` 인스턴스가 저장돼 있다. 그리고 (5)는 이 배열의 처음 리스트에서 첫 원소를 꺼내려 한다. <br>
5️⃣ 컴파일러는 꺼낸 원소를 자동으로 `String`으로 형변환하는데, 이 원소는 `Integer`이므로 런타임에 `ClassCastException`이 발생한다.<br>

**따라서, 이런 일을 방지하려면 (1)에서 컴파일 오류를 내야 한다.** <br>
소거 매커니즘 때문에 매개변수화 타입 가운데 실체화될 수 있는 타입은 `List<?>`와 `Map<?,?>` 같은 비한정적 와일드 카드 타입뿐이다. <br>
but, 배열을 비한정적 와일드카드 타입으로 만들 수는 있지만, 유용하게 쓰일 일은 거의 없다.

* 생성자에서 컬렉션을 받는 Chooser 클래스
```java
public class Chooser {
    
    private final Object[] choiceArray;

    public Chooser(Collection choiceArray) {
        this.choiceArray = choiceArray.toArray();
    }
    
    public Object choose(){
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
```
* 리스트 기반 Chooser - 타입 안전성 확보!
```java
public class Chooser<T> {

    private final List<T> choiceArray;

    public Chooser(Collection<T> choiceArray) {
        this.choiceArray = new ArrayList<>(choiceArray);
    }

    public T choose(){
        Random rnd = ThreadLocalRandom.current();
        return choiceArray.get(rnd.nextInt(choiceArray.size()));
    }
}
```


## 🎯  아이템 29. 이왕이면 제네릭 타입으로 만들라.
## 🎯  아이템 30. 이왕이면 제네릭 메서드로 만들라.
## 🎯  아이템 31. 한정적 와일드카드를 사용해 API 유연성을 높이라.
## 🎯  아이템 32. 제네릭과 가변인수를 함께 쓸 때는 신중하라.
## 🎯  아이템 33. 타입 안정 이종 컨테이너를 고려하라.

## ⭐ 결론