## 객체와 자료구조.

<br>

#### 자료 추상화.

* 6-1 구체적인 Point 클래스 <br>

```java
public class Point {
    public double x;
    public doucle y;
}
```

<br>

* 6-2 추상적인 Point 클래스 <br>

```java
public interface Point {
    double getX();
    double getY();
    void setCartesian(double x, double y);
    double getR();
    double getTheta();
    void setPolar(double r, double theta);
}
```

<br>

* 6-3 구체적인 Vehicle 클래스 <br>

```java
public interface Vehicle {
    double getFuelTankCapacityInGallons();
    double getGallonsOfGasoline();
}
```

<br>

* 6-4 추상적인 Vehicle 클래스 <br>

```java
public interface Vehicle {
    double getPercentFuelRemaining();
}
```

<br>

6-1과 6-2에서는 6-2가, 6-3과 6-4에서는 6-4가 더 좋다. 자료를 세세하게 공개하기보다는 추상적인 개념으로 표현하는 편이 좋다. <br>

<br>

#### 자료/객체 비대칭

> 절차적인 코드는 기존 자료 구조를 변경하지 않으면서 새 함수를 추가하기 쉽다. <br>
> 반면, 객체 지향 코드는 기존 함수를 변경하지 않으면서 새 클래스를 추가하기 쉽다. <br>

<br>

> 절차적인 코드는 새로운 자료 구조를 추가하기 어렵다. 그러려면 모든 함수를 고쳐야 한다. <br>
> 객체 지향 코드는 새로운 함수를 추가하기 어렵다. 그러려면 모든 클래스를 고쳐야 한다. <br>

<br>

#### 디미터 법칙

디미터 법칙은 잘 알려진 휴리스틱으로, 모듈은 자신이 조작하는 객체의 속사정을 몰라야 한다는 법칙이다. <br>
객체는 자료를 숨기고 함수를 공개한다. 즉, 객체는 조회 함수로 내부 구조를 공개하면 안된다는 의미다. <br>
좀 더 정확히 표현하자면, 디미터 법칙은 "클래스 C의 메서드 f는 다음과 같은 객체의 메서드만 호출해야 한다"고 주장한다. <br>

1. 클래스 C
2. f가 생성한 객체
3. f 인수로 넘어온 객체
4. C 인스턴스 변수에 저장된 객체

하지만 위 객체에서 허용된 메서드가 반환하는 객체의 메서드는 호출하면 안된다. <br>
다시 말해, 낯선 사람은 경계하고 친구랑만 놀라는 의미다. <br>

<br>

#### 결론

객체는 동작을 공개하고 자료를 숨긴다. 그래서 기존 동작을 변경하지 않으면서 새 객체 타입을 추가하기는 쉬운 반면, <br>
기존 객체에 새 동작을 추가하기는 어렵다. 자료 구조는 별다른 동작 없이 자료를 노출한다. 그래서 기존 자료 구조에 <br>
새 동작을 추가하기는 쉬우나, 기존 함수에 새 자료 구조를 추가하기는 어렵다. <br>

어떤 시스템을 구현할 때, 새로운 자료 타입을 추가하는 유연성이 필요하면 객체가 더 적합하다. 다른 경우로 새로운 동작을 <br>
추가하는 유연성이 필요하면 자료 구조와 절차적인 코드가 더 적합하다. 우수한 개발자는 편견없이 이 사실을 이해해 직면한 <br>
문제에 최적인 해결책을 선택한다. <br>

<br>

> Robert C. Martin, 『Clean Code』, 박재호 * 이해영 옮김, 인사이트(2013), p118-128.