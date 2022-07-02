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

#### 5. 솔직히 말하자면
우선은 `Dollar` 객체와 비슷하지만 달러 대신 프랑(Franc)을 표현할 수 있는 객체가 필요할 것 같다.
```java
@Test
void testFrancMultiplication() {
    Dollar five = new Dollar(5);
    assertThat(new Dollar(10)).isEqualTo(five.times(2));
    assertThat(new Dollar(15)).isEqualTo(five.times(3));
}
```
```java
public class Franc {

    private int amount;

    Franc(int amount){
        this.amount = amount;
    }

    Franc times(int multiplier){
        return new Franc(amount * multiplier);
    }

    public boolean equals(Object o) {
        Franc franc = (Franc) o;
        return amount == franc.amount;
    }
}
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
> ~~5CHF * 2 = 10CHF~~ <br>
> Dollar/Franc 중복 <br>
> 공용 equals <br>
> 공용 times <br>

중복이 엄청나게 많기 때문에 다음 테스트를 작성하기 전에 이것들을 제거해야한다.<br>
`equals()`를 일반화하는 것부터 시작!<br>

#### 6. 돌아온 '모두를 위한 평등'
테스트를 빨리 통과하기 위해 몇 톤이나 되는 코드를 복사해서 붙이는 엄청난 죄를 저질렀다.<br>
두 클래스의 공통 상위 클래스 `Money`를 생성하여 `Money` 클래스가 공통의 `equals` 코드를 갖게하자.<br>
> $5 + 10CHF = $10 (환율이 2:1일 경우) <br>
> ~~$5 * 2 = $10~~ <br>
> ~~amount를 private으로 만들기~~ <br>
> ~~Dollar 부작용?~~ <br>
> Money 반올림? <br>
> ~~equals()~~ <br>
> hashCode() <br>
> Equal null <br>
> Equal object <br>
> ~~5CHF * 2 = 10CHF~~ <br>
> Dollar/Franc 중복 <br>
> ~~공용 equals~~ <br>
> 공용 times <br>
> Franc과 Dollar 비교하기 <br>


#### 7. 사과와 오렌지
```java
@Test
void testEquality() {
    assertThat(new Dollar(5).equals(new Dollar(5))).isTrue();
    assertThat(new Dollar(5).equals(new Dollar(6))).isFalse();
    assertThat(new Franc(5).equals(new Franc(5))).isTrue();
    assertThat(new Franc(5).equals(new Franc(6))).isFalse();

    // Franc Dollar 비교
    assertThat(new Franc(5).equals(new Dollar(5))).isFalse();
}
```
테스트를 진행해보면 `Franc`이 `Dollar`라는 결과가 나오게 된다. <br>
동치성 코드에서는 `Dollar`가 `Franc`과 비교되지 않는지 검사해야한다.<br>
```java
public boolean equals(Object o) {
    Money money = (Money) o;
    return amount == money.amount &&
            getClass().equals(money.getClass());
}
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
> ~~5CHF * 2 = 10CHF~~ <br>
> Dollar/Franc 중복 <br>
> ~~공용 equals~~ <br>
> 공용 times <br>
> ~~Franc과 Dollar 비교하기~~ <br>
> 통화? <br>

#### 8. 객체 만들기
`Money`에 `Dollar`와 `Franc` 반환하는 팩토리 메서드 도입<br>
```java
static Money dollar(int amount){
    return new Dollar(amount);
}

static Money franc(int amount){
    return new Franc(amount);
}
```
`Money`를 추상 클래스로 변경한 후 `Money.times()` 선언<br>
```java
abstract Money times(int multiplier);
```
```java
@Test
void testMultiplication() {
    Money five = Money.dollar(5);
    assertThat(Money.dollar(10)).isEqualTo(five.times(2));
    assertThat(Money.dollar(15)).isEqualTo(five.times(3));
}
```
어떤 클라이언트 코드도 `Dollar`라는 이름의 하위 클래스가 있다는 사실을 알지 못한다. <br>
하위 클래스의 존재 테스트에서 분리함으로써 어떤 모델 코드에도 영향을 주지 않고 상속 구조를 마음대로 변경할 수 있게 됐다.<br>
> $5 + 10CHF = $10 (환율이 2:1일 경우) <br>
> ~~$5 * 2 = $10~~ <br>
> ~~amount를 private으로 만들기~~ <br>
> ~~Dollar 부작용?~~ <br>
> Money 반올림? <br>
> ~~equals()~~ <br>
> hashCode() <br>
> Equal null <br>
> Equal object <br>
> ~~5CHF * 2 = 10CHF~~ <br>
> Dollar/Franc 중복 <br>
> ~~공용 equals~~ <br>
> 공용 times <br>
> ~~Franc과 Dollar 비교하기~~ <br>
> 통화? <br>
> testFrancMultiplication을 지워야 할까? <br>

#### 9. 우리가 사는 시간
통화를 표현하기 위한 복잡한 객체들을 원할 수 있다. 그리고 그 객체들이 필요한 만큼만 <br>
만들어지도록 하기 위해 경량 팩토리를 사용할 수 있을 것이다. 하지만 일단 문자열을 사용하자.<br>
```java
@Test
void testCurrency() {
    assertThat("USD").isEqualTo(Money.dollar(1).currency());
    assertThat("CHF").isEqualTo(Money.franc(1).currency());
}
```
```java
protected String currency;
```
통화를 구분하기 위한 문자열 변수를 생성하고
```java
Franc(int amount, String currency){...}
```
생성자에 통화를 입력해주고 문자열은 정적 팩토리 메서드로 옴긴다.
```java
static Money franc(int amount){
    return new Franc(amount, "CHF");
}
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
> ~~5CHF * 2 = 10CHF~~ <br>
> Dollar/Franc 중복 <br>
> ~~공용 equals~~ <br>
> 공용 times <br>
> ~~Franc과 Dollar 비교하기~~ <br>
> ~~통화?~~ <br>
> testFrancMultiplication 제거 <br>

#### 10. 흥미로운 시간
더 이상 `Money`클래스의 `times`는 추상 메서드가 아닌 공용 `times`로 만든다.<br>
```java
Money times(int multiplier){
    return new Money(amount*multiplier, currency);
}
```
`Money` 클래스를 생성하기 위해서 `Money` 클래스도 콘크리트 클래스로 변경되어야 한다.<br>
```java
public class Money { ... }
```
```java
@Test
void testDifferentClassEquality() {
    assertThat(new Money(10,"CHF")).isEqualTo(new Franc(10,"CHF"));
}
```
위 테스트에 두 클래스가 다른 클래스임에도 테스트가 통과하려면 `equals`를 변경해야한다.<br>
```java
public boolean equals(Object o) {
    Money money = (Money) o;
    return amount == money.amount &&
            currency().equals(money.currency());
}
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
> ~~5CHF * 2 = 10CHF~~ <br>
> Dollar/Franc 중복 <br>
> ~~공용 equals~~ <br>
> ~~공용 times~~ <br>
> ~~Franc과 Dollar 비교하기~~ <br>
> ~~통화?~~ <br>
> testFrancMultiplication 제거 <br>

#### 11. 모든 악의 근원
두 하위 클래스인 `Dollar`, `Franc`는 이제 생성자밖에 남지 않았다. <br>
단지 생성자 때문에 하위 클래스가 있을 필요는 없기 때문에 제거하도록 한다. <br>
기존소스에서는 필요했지만 새로운 소스에선 필요없는 테스트는 제거한다. <br>
> $5 + 10CHF = $10 (환율이 2:1일 경우) <br>
> ~~$5 * 2 = $10~~ <br>
> ~~amount를 private으로 만들기~~ <br>
> ~~Dollar 부작용?~~ <br>
> Money 반올림? <br>
> ~~equals()~~ <br>
> hashCode() <br>
> Equal null <br>
> Equal object <br>
> ~~5CHF * 2 = 10CHF~~ <br>
> ~~Dollar/Franc 중복~~ <br>
> ~~공용 equals~~ <br>
> ~~공용 times~~ <br>
> ~~Franc과 Dollar 비교하기~~ <br>
> ~~통화?~~ <br>
> testFrancMultiplication 제거 <br>

#### 12. 드디어, 더하기
큰 테스트를 작은 테스트($5 + 10CHF -> $5 + $5)로 줄여서 발전을 나타낼 수 있도록 했다. <br>
우리에게 필요한 계산에 대한 가능한 메타포들을 기반하여 테스트를 재작성했다. <br>

#### 13. 진짜로 만들기
명시적인 클래스 검사를 제거하기 위해 다형성을 사용<br>
> $5 + 10CHF = $10(환율이 2:1일 경우) <br>
> $5 + $5 = $10 <br>
> $5 + $5에서 Money 반환하기 <br>
> ~~Bank.reduce(Money)~~ <br>
> Money에 대한 통화 변환을 수행하는 Reduce <br>
> Reduce(Bank, String) <br>


#### 14. 바꾸기
2프랑이 있는데 이걸 달러로 바꾸고 싶다.<br>
```java
@Test
void testReduceMoneyDifferentCurrency() {
    Bank bank = new Bank();
    bank.addRate("CHF", "USD", 2);
    Money result = bank.reduce(Money.franc(2), "USD");
    assertThat(Money.dollar(1)).isEqualTo(result);
}
```
> $5 + 10CHF = $10(환율이 2:1일 경우) <br>
> ~~$5 + $5 = $10~~ <br>
> $5 + $5에서 Money 반환하기 <br>
> ~~Bank.reduce(Money)~~ <br>
> ~~Money에 대한 통화 변환을 수행하는 Reduce~~ <br>
> ~~Reduce(Bank, String)~~ <br>

#### 15. 서로 다른 통화 더하기
드디어 이 모든 작업의 시초인 `$5 + 10CHF` 에 대한 테스트를 추가할 준비가 됐다.<br>
```java
@Test
void testMixedAddition() {
    Expression fiveBucks = Money.dollar(5);
    Expression tenFrances = Money.franc(10);
    Bank bank = new Bank();
    bank.addRate("CHF","USD", 2);
    Money result = bank.reduce(fiveBucks.plus(tenFrances), "USD");
    assertThat(Money.dollar(10)).isEqualTo(result);
}
```
> $5 + 10CHF = $10(환율이 2:1일 경우) <br>
> ~~$5 + $5 = $10~~ <br>
> $5 + $5에서 Money 반환하기 <br>
> ~~Bank.reduce(Money)~~ <br>
> ~~Money에 대한 통화 변환을 수행하는 Reduce~~ <br>
> ~~Reduce(Bank, String)~~ <br>
> Sum.plus <br>
> Expression.times <br>

좀더 추상적인 선언을 통해 가지에서 뿌리로 일반화했다.<br>
변경후 (Expression fiveBucks), 그 영향을 받은 다른 부분들을 변경하기 위해 컴파일러의 지시를 따랐다.<br>

#### 16. 드디어 추상화
Expression.plus를 끝마치려면 Sum.plus()를 구현해야 한다. <br>
그리고 나서 Expression.times()를 구현하면 전체 예제가 끝난다.<br>
> ~~$5 + 10CHF = $10(환율이 2:1일 경우)~~ <br>
> ~~$5 + $5 = $10~~ <br>
> ~~Bank.reduce(Money)~~ <br>
> ~~Money에 대한 통화 변환을 수행하는 Reduce~~ <br>
> ~~Reduce(Bank, String)~~ <br>
> ~~Sum.plus~~ <br>
> ~~Expression.times~~ <br>
