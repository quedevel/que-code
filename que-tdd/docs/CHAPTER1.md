## 화폐 예제
* 테스트 주도 개발의 리듬
1. 재빨리 테스트를 하나 추가한다.
2. 모든 테스트를 실행하고 새로 추가한 것이 실패하는지 확인한다.
3. 코드를 조금 바꾼다.
4. 모든 테스트를 실행하고 전부 성공하는지 확인한다.
5. 리팩토링을 통해 중복을 제거한다.

#### 1. 다중 통화를 지원하는 Money객체

> $5 + 10CHF = $10 (환율이 2:1일 경우) <br>
> ~~$5 * 2 = $10~~ <br>
> amount를 private으로 만들기 <br>
> Dollar 부작용? <br>
> Money 반올림? <br>

```java
@Test
void testMultiplication() {
    //given
    Dollar five = new Dollar(5);

    //when
    five.times(2);

    //then
    assertThat(10).isEqualTo(five.amount);
}
```

#### 작업 목록
* 테스트 목록 생성
* 외부에서 어떻게 보이길 원하는지 코드로 표현
* 스텁 구현을 통해 테스트를 컴파일
* 끔찍한 죄악을 범하여 테스트 통과
* 상수를 변수로 변경하여 점진적으로 일반화
* 한번에 처리 보다는 할일 목록에 추가하고 넘어감


#### 2. 타락한 객체
테스트를 하나 통과했지만 `Dollar`에 대해 연산을 수행한 후에 <br>
해당 `Dollar`의 값이 바뀌는 점이다.<br>

> $5 + 10CHF = $10 (환율이 2:1일 경우) <br>
> ~~$5 * 2 = $10~~ <br>
> amount를 private으로 만들기 <br>
> ~~Dollar 부작용?~~ <br>
> Money 반올림? <br>

```java
@Test
void testMultiplication() {
    //given
    Dollar five = new Dollar(5);
    //when
    Dollar product = five.times(2);
    //then
    assertThat(10).isEqualTo(product.amount);
    //when
    product = five.times(3);
    //then
    assertThat(15).isEqualTo(product.amount);
}
```
```java
public class Dollar {

    int amount;

    Dollar(int amount){
        this.amount = amount;
    }

    Dollar times(int multiplier){ 
        return new Dollar(amount * multiplier); 
    }
}
```

#### 작업 목록
* 설계상의 결함(Dollar 부작용)을 그 결함으로 인해 실패하는 테스트로 변환.
* 스텁 구현으로 빠르게 컴파일을 통과
* 올바르다고 생각하는 코드를 입력


#### 3. 모두를 위한 평등
지금의 `Dollar` 객체같이 객체를 값처럼 쓸 수 있는데 이것을 값 객체 패턴(value object pattern)이라고 한다.<br>
값 객체에 대한 제약사항 중 하나는 객체의 인스턴스 변수가 생성자를 통해서 일단 설정된 후에는 결코 변하지 않는다.<br>
> $5 + 10CHF = $10 (환율이 2:1일 경우) <br>
> ~~$5 * 2 = $10~~ <br>
> amount를 private으로 만들기 <br>
> ~~Dollar 부작용?~~ <br>
> Money 반올림? <br>
> ~~equals()~~ <br>
> hashCode() <br>
> Equal null <br>
> Equal object <br>

* 동치성의 일반화
```java
public boolean equals(Object o) {
    Dollar dollar = (Dollar) o;
    return amount == dollar.amount;
}
```

#### 4. 프라이버시
```java
@Test
void testMultiplication() {
    Dollar five = new Dollar(5);
    assertThat(new Dollar(10)).isEqualTo(five.times(2));
    assertThat(new Dollar(15)).isEqualTo(five.times(3));
}
```
이 테스트는 일련의 오퍼레이션이 아니라 참인 명제에 대한 단언들이므로 우리의 의도를 더 명확하게 이야기 해준다. <br>
테스트를 고치고 나니 이제 `Dollar`의 `amount` 인스턴스 변수를 사용하는 코드는 `Dollar` 자신밖에 없으므로 <br>
변수를 `private`으로 변경 할 수 있다.<br>
```java
private int amount;
```
> $5 + 10CHF = $10 (환율이 2:1일 경우) <br>
> ~~$5 * 2 = $10~~ <br>
> ~~amount를 private으로 만들기~~ <br>
> ~~Dollar 부작용?~~ <br>
> Money 반올림? <br>
> ~~equals()~~ <br>
> hashCode() <br>
> Equal null <br>
> Equal object <br>

