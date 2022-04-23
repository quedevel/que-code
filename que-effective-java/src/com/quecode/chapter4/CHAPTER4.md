# 🔥 [ Chapter4 ] 클래스와 인터페이스
**_추상화의 기본 단위인 클래스와 인터페이스는 자바 언어의 심장과도 같다._**

## 🎯  아이템 15. 클래스와 맴버의 접근 권한을 최소화하라.
> 오직 API를 통해서만 다른 컴포넌트와 소통하며 서로의 내부 동작 방식에는 전혀 개의치 않는다.<br>
> 정보 은닉, 혹은 <span style='color:red;'>캡슐화</span>라고 하는 이 개념은 소프트웨어 설계의 근간이 되는 원리이다.

<br>

⭐ **정보 은닉의 핵심 : 모든 클래스와 맴버의 접근성을 가능한 한 좁혀야 한다.**
<img width="60%" src="https://user-images.githubusercontent.com/55771326/164727088-978eab11-1382-4955-95f8-782185c93f5f.png">

<br>


⭐ **`public` 클래스의 인스턴스 필드는 되도록 `public`이 아니어야 한다.**
```java
public class User {
    private long userSn;
    private String userId;
    private String userPw;
}    
```

<br>


⭐ **`public` 가변 필드를 갖는 클래스는 일반적으로 스레드(멀티 스레드에) 안전하지 않다.**

**<span style='color:red;'>스레드 불안정</span> : 상태 제어가 잘못되면 프로그램은 불안정해져서 먹통이 되거나 다운되는것을 말한다.**


<br>


⭐ **클래스에서 `public static final` 배열 필드를 두거나 이 필드를 반환하는 접근자 메서드를 제공해서는 안되다.**
* **이전 코드**
```java
private static final Thing[] PRIVATE_VALUES = { ... };
public static final List<Thing> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));
```
* **변경 후 코드**
```java
private static final Thing[] PRIVATE_VALUES = { ... };
public static final Thing[] values(){
    return PRIVATE_VALUES.clone();    
}
```

> `public` 클래스는 상수용 `public static final` 필드 외에는 어떠한 `public` 필드도 가져서는 안된다.<br>
> `public static final` 필드가 참조하는 객체가 <span style='color:red;'>불변</span>인지 확인하라.

## 🎯  아이템 16. public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용하라.

* **이전 코드**
```java
public class Point {
    // public
    public double x;
    public double y;
}
```
* **변경 후 코드**
```java
public class Point {
    // private
    private double x;
    private double y;
    
    // getter, setter
    public double getX() { return x; }
    public double getY() { return y; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
}
```
> `public` 클래스는 절대 가변 필드를 직접 노출해서는 안 된다. 불변 필드라면 노출해도<br> 
> 덜 위험하지만 완전히 안심할 수는 없다. 하지만 `package-private` 클래스나 `private` <br>
> 중첩 클래스에서는 종종 (불변이든 가변이든) 필드를 노출하는 편이 나을 때도 있다.

## 🎯  아이템 17. 변경 가능성을 최소화하라.
_**불변 클래스는 가변 클래스보다 설계하고 구현하고 사용하기 쉬우며, 오류가 생길 여지도 적고 훨씬 안전하다.**_

* 클래스를 불변으로 만들기 위한 5가지 규칙
> 1️⃣ 객체의 상태를 변경하는 메서드(setter)를 제공하지 않는다. <br>
> 2️⃣ 클래스를 확장할 수 없도록 한다. <br>
> 3️⃣ 모든 필드를 final로 선언한다. <br>
> 4️⃣ 모든 필드를 private으로 선언한다. <br>
> 5️⃣ 자신 외에는 내부의 가변 컴포넌트에 접근할 수 없도록 한다. <br>

* 예제 ) 불변의 복소수 클래스
```java
// class를 final로 선언하여 확장할 수 없도록 함
public final class Complex {
    // 모든 필드를 private final로 선언
    private final double re;
    private final double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    // getter만 존재 setter는 만들지 않는다.
    public double getRe() { return re; }
    public double getIm() { return im; }
    
    public Complex plus(Complex complex) { return new Complex(re + complex.re, im + complex.im); }
    
    ...생략
}
```
setter 제공하지 않으며 생성자로 인하여 불변식 설정이 모두 완료된, 초기화가 완벽히 끝난 상태의 객체를 생성하게 된다.<br>

<br>

* 불변 클래스의 장점
> 1️⃣ 불변 객체는 근본적으로 스레드 안전하여 따로 동기화할 필요 없다. <br>
> 2️⃣ 불변 객체는 안심하고 공유할 수 있다. <br>
> 3️⃣ 불변 객체는 자유롭게 공유할 수 있음은 물론, 불변 객체끼리는 내부 데이터를 공유할 수 있다. <br>
> 4️⃣ 불변 객체는 그 자체로 실패 원자성을 제공한다. <br>

## 🎯  아이템 18. 상속보다는 컴포지션을 사용하라.
_**상속은 상위 클래스가 어떻게 구현되느냐에 따라 하위 클래스의 동작에 이상이 생길 수 있다.<br>
그 여파로 코드 한 줄 건드리지 않은 하위 클래스가 오동작할 수 있다.<br>**_

* 잘못된 예 - 상속을 잘못 사용했다.
```java
public class InstrumentedHashSet<E> extends HashSet<E> {
    private int addCount = 0;
    public InstrumentedHashSet(){};
    public InstrumentedHashSet(int initCap, float loadFactor){
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c); // add(e)를 호출한다.
    }

    public int getAddCount(){
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("ㄱ","ㄴ","ㄷ"));
        System.out.println("s.getAddCount() : "+s.getAddCount());
    }
}
```
예상한 결과값은 `3`이겠지만 실제로는 6을 반환한다.
<img width="50%" src="https://user-images.githubusercontent.com/55771326/164878844-8c7f48d3-078f-4582-ac36-04fa740275f7.PNG">

```java
public boolean addAll(Collection<? extends E> c) {
    boolean modified = false;
    for (E e : c)
        if (add(e))
            modified = true;
    return modified;
}
```
`super.addAll(c)`의 구현체에서 `add(e)`를 실행하기 때문이다.

⭐ **이러한 문제를 모두 피해가는 묘안으로 컴포지션을 사용하자.** <br>
_새 클래스의 인스턴스 메서드들은 기존 클래스의 대응하는 메서드를 호출해 그 결과를 반환한다.<br> 
이 방식을 `forwarding`이라 하며, 새 클래스의 메서드들을 전달 메서드라 부른다._

* 래퍼 클래스 - 상속 대신 컴포지션을 사용
```java
public class InstrumentedSet<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override public boolean add(E e) {
        addCount++;
        return super.add(e);
    }
    @Override public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }
    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedSet<String> s = new InstrumentedSet<>(new HashSet<>());
        s.addAll(List.of("ㄱ", "ㄴ", "ㄷ"));
        System.out.println("s.getAddCount() = "+s.getAddCount());
    }
}
```
* 재사용할 수 있는 전달 클래스
```java
public class ForwardingSet<E> implements Set<E> {
    private final Set<E> s;
    public ForwardingSet(Set<E> s) { this.s = s; }

    public int size()                 { return s.size();      }
    public boolean add(E e)           { return s.add(e);      }
    public boolean addAll(Collection<? extends E> c)
    { return s.addAll(c);      }
    
    ... 생략
}
```
하나는 집합 클래스 자신이고, 다른 하나는 전달 메서드만으로 이뤄진 재사용 가능한 전달 클래스다.<br>
<img width="50%" src="https://user-images.githubusercontent.com/55771326/164879225-0ace43e3-0dc7-419b-81b0-af6f8e45f9be.PNG">

<br>

> **상속**은 강력하지만 **캡슐화**를 해친다는 문제가 있다. **상속**은 상위 클래스와 하위 클리스가<br> 
> 순수한 is-a 관계일 때만 써야한다. is-a 관계일 때도 안심할 수만은 없는 게, 하위 클래스의<br>
> 패키지가 상위 클래스와 다르고, 상위 클래스가 확장을 고려해 설계되지 않았다면<br>
> 여전히 문제가 될 수 있다. **상속**의 취약점을 피하려면 **상속** 대신 **컴포지션**과 전달을 사용하자.<br>
> 특히 래퍼 클래스로 구현할 적당한 인터페이스가 있다면 더욱 그렇다. 래퍼 클래스는<br> 
> 하위 클래스보다 견고하고 강력하다.

## 🎯  아이템 19. 상속을 고려해 설계하고 문서화하라. 그러지 않았다면 상속을 금지하라.

## 🎯  아이템 20. 추상 클래스보다는 인터페이스를 우선하라.

## 🎯  아이템 21. 인터페이스는 구현하는 쪽을 생각해 설계하라.

## 🎯  아이템 22. 인터페이스는 타입을 정의하는 용도로만 사용하라.

## 🎯  아이템 23. 태그 달린 클래스보다는 클래스 계층구조를 활용하라.

## 🎯  아이템 24. 맴버 클래스는 되도록 static으로 만들라.

## 🎯  아이템 25. 톱레벨 클래스는 한 파일에 하나만 담으라.

## ⭐ 결론