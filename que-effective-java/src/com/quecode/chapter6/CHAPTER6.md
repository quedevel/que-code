# 🔥 [ Chapter6 ] 열거 타입과 애너테이션


## 🎯  아이템 34. int 상수 대신 열거 타입을 사용하라.
* 정수 열거 패턴 - 상당히 취약하다!
```java
public class IntegerConstants {
    public static final int APPLE_FUJI = 0;
    public static final int APPLE_PIPPIN = 1;
    public static final int APPLE_GRANNY_SMITH = 2;

    public static final int ORANGE_NAVEL = 0;
    public static final int ORANGE_TEMPLE = 1;
    public static final int ORANGE_BLOOD = 2;
}
```
위 같은 정수 열거 패턴은 타입 안전을 보장할 방법이 없으며 표현력도 좋지 않다.<br>
오렌지를 건네야 할 메서드에 사과를 보내고 `동등 연산자(==)`로 비교하더라도 컴파일러는 아무런 경고 메시지를 출력하지 않는다.<br>


<br>

* 가장 단순한 열거 타입
```java
public enum Apple { FUJI, PIPPIN, GRANNY_SMITH }
public enum Orange { NAVEL, TEMPLE, BLOOD }
```
자바의 열거 타입은 완전한 형태의 클래스라서 다른 언어의 열거 타입보다 훨씬 강력하다.<br>
열거 타입은 밖에서 접근할 수 있는 생성자를 제공하지 않으므로 사실상 `final`이다.<br>
따라서 클라이언트가 인스턴스를 직접 생성하거나 확장 할 수 없으니 열거 타입 선언으로 만들어진 인스턴스들은 딱 하나씩만 존재함이 보장된다.<br>
<span style="color:red; font-weight: bold;">if</span>. `Apple` 열거 타입을 매개변수로 받는 메서드를 선언했다면, 건네받은 참조는 `Apple`의 세 가지 값 중 하나임이 확실하다.<br>
다른 타입의 값을 넘기려 하면 컴파일 오류가 난다.<br>

<br>

* 데이터와 메서드를 갖는 열거 타입
```java
public enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    VENUS  (4.869e+24, 6.052e6),
    EARTH  (5.975e+24, 6.378e6),
    MARS   (6.419e+23, 3.393e6),
    JUPITER(1.899e+27, 7.149e7),
    SATURN (5.685e+26, 6.027e7),
    URANUS (8.683e+25, 2.556e7),
    NEPTUNE(1.024e+26, 2.477e7);

    private final double mass;           // 질량(단위: 킬로그램)
    private final double radius;         // 반지름(단위: 미터)
    private final double surfaceGravity; // 표면중력(단위: m / s^2)

    // 중력상수(단위: m^3 / kg s^2)
    private static final double G = 6.67300E-11;

    // 생성자
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass()           { return mass; }
    public double radius()         { return radius; }
    public double surfaceGravity() { return surfaceGravity; }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;  // F = ma
    }
}
```
_**열거 타입 상수 각각을 특정 데이터와 연결지으려면 생성자에서 데이터를 받아 인스턴스 필드에 저장하면된다.**_ <br>

<br>

위의 Planet 예에서 보여준 특성만으로 연거 타입을 사용하는 상황 대다수를 훌륭히 설명할 수 있다.<br>
하지만 상수가 더 다양한 기능을 제공해줬으면 할 때도 있다.<br>

<br>

* 값에 따라 분기하는 열거 타입 - 이대로 만족하는가?
```java
public enum Operation {
    PLUS, MINUS, TIMES, DIVIDE;
    
    public double apply(double x, double y){
        switch (this){
            case PLUS: return x+y;
            case MINUS: return x-y;
            case TIMES: return x*y;
            case DIVIDE: return x/y;
        }
        throw new AssertionError("알 수 없는 연산: " + this);
    }
}
```
위 소스는 동작은 하지만 다른 연산을 추가할때는 case문을 추가를 해야한다.<br>
만약 까먹고 case문은 추가하지 않는다 하더라도 컴파일 에러가 발생하지 않고 런타입중 "알 수 없는 연산"이라는 오류를 발생한다.<br>
따라서 상수별 클래스 몸체, 즉 각 상수에서 자신에 맞게 재정의하는 방법이 있다.<br>

<br>

* 상수별 메서드 구현을 활용한 열거 타입
```java
public enum Operation2 {
    PLUS { public double apply(double x, double y){ return x+y; } },
    MINUS { public double apply(double x, double y){ return x-y; } },
    TIMES { public double apply(double x, double y){ return x*y; } },
    DIVIDE { public double apply(double x, double y){ return x/y; } };

    public abstract double apply(double x, double y); // 추상 메서드를 선언
}
```
위 처럼 추상메서드 `apply`를 선언하면 다른 연산을 추가할 때도 메서드 구현체를 같이 추가하지 않는다면 <br>
컴파일 오류가 발생하기 때문에 안전하다.

<br>

## 🎯  아이템 35. ordinal 메서드 대신 인스턴스 필드를 사용하라.
열거 타입은 해당 상수가 그 열거 타입에서 몇 번째 위치인지를 반환하는 `ordinal`이라는 메서드를 제공한다.
```java
public enum RoleType {
    USER, ADMIN;
}
```
```java
@Entity
public class Member {
    @Id
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.ORDINAL)
    private RoleType roleType;
}    
```
위 처럼 `javax.persistence`에서 제공하는 타입을 enum으로 지정하는 `@Enumerated`을 제공해준다.<br>
`@Enumerated` 애너테이션에는 두 가지 옵션이 있는데 `EnumType.ORDINAL`과 `EnumType.STRING`이 있는데 <br>
`EnumType.ORDINAL`을 옵션으로 넣으면 내부적으로 `ordinal`함수를 사용하기 때문에 enum값을 순서로 저장하게 되는데<br>
여기서 만약 `RoleType`에 추가가 된다면 `GUEST`라는 값이 앞에서 추가가 된다면 `USER`로 저장된 값은 `GUEST`로 되기 때문에 위험하다.<br>
```java
public enum RoleType {
    GUEST, USER, ADMIN;
}
```
따라서, 특별한 용도가 아니라면 `ordinal` 메서드는 절대 사용하지 말자

<br>

## 🎯  아이템 36. 비트 필드 대신 EnumSet을 사용하라.
* 비트 필드 열거 상수 - 구닥다리 기법!
```java
public class Text {
    public static final int STYLE_BOLD          = 1 << 0; // 1
    public static final int STYLE_ITALIC        = 1 << 1; // 2
    public static final int STYLE_UNDERLINE     = 1 << 2; // 4
    public static final int STYLE_STRIKETHROUGH = 1 << 3; // 5
    
    public void applyStyles(int styles){ ... }
}
```
다음과 가은 식으로 비트별 OR를 사용해 여러 상수를 하나의 집합으로 모을 수 있으며, 이렇게 만들어진 집합을 비트 필드라 한다. <br>
```java
text.applyStyles(STYLE_BOLD | STYLE_ITALIC);
```
하지만 비트 필드는 정수 열거 상수의 단점을 그대로 지니며, 추가로 다음과 같은 문제까지 있다. <br>
비트 필드 값이 그대로 출력되면 단순한 정수 열거 상수를 출력할 때보다 해석하기가 어렵다.<br>

<br>

* EnumSet - 비트 필드를 대체하는 현대적 기법
```java
public class Text {
    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    // 어떤 Set을 넘겨도 되나, EnumSet이 가장 좋다.
    public void applyStyles(Set<Style> styles) {
        System.out.printf("Applying styles %s to text%n", Objects.requireNonNull(styles));
    }

    // 사용 예
    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}
```
**_EnumSet 클래스가 비트 필드 수준의 명료함과 성능을 제공하고 열거 타입의 장점까지 선사한다._**

## 🎯  아이템 37. ordinal 인덱싱 대신 EnumMap을 사용하라.

## 🎯  아이템 38. 확장할 수 있는 열거 타입이 필요하면 인터페이스를 사용하라.

## 🎯  아이템 39. 명명 패턴보다 애너테이션을 사용하라.

## 🎯  아이템 40. @Override 애너테이션을 일관되게 사요하라.

## 🎯  아이템 41. 정의하려는 것이 타입이라면 마커 인터페이스를 사요하라.



<br>

> Joshua Bloch, 『Effective Java 3/E』, 개앞맵시 옮김, 프로그래밍인사이트(2018), p207-251.