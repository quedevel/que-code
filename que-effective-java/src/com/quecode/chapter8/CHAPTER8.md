# 🔥 [ Chapter8 ] 메서드

## 🎯  아이템 49. 매개변수가 유효한지 검사하라.
#### "오류는 가능한 한 빨리 (발생한 곳에서) 잡아야 한다" <br>
오류를 발생한 즉시 잡지 못하면 해당 오류를 감지하기 어려워지고, 감지하더라도 오류의 발생 지점을 찾기 어려워 진다.<br>
<br>

#### 만약, 매개변수 검사를 제대로 하지 못하면 몇 가지 문제가 생길 수 있다.
메서드가 수행되는 중간에 모호한 예외를 던지며 실패할 수 있다. <br>
매개변수 검사에 실패하면 **실패 원자성**을 어기는 결과를 낳을 수 있다.<br>
**_실패 원자성 : 메서드에서 예외가 발생한 후에도 그 객체는 여전히 유효한 상태_**<br>

`public`과 `protected` 메서드는 매개변수 값이 잘못됐을 때 던지는 예외를 문서화해야 한다.<br>
(`@throws` 자바독 태그를 사용하면 된다.)<br>
```java
    /**
     * (현재 값 mod m) 값을 반환한다. 이 메서드는
     * 항상 음이 아닌 BigInteger를 반환한다는 점에서 remainder 메서드와 다르다.
     * 
     * @param m 계수 (양수여야 한다.)
     * @return 현재 값 mod m
     * @throws ArithmeticException m이 0보다 작거나 같으면 발생한다.
     */
    public BigInteger mod(BigInteger m){
        if (m.signum() <= 0){
            throw new ArithmeticException("계수 (m)는 양수여야 합니다. "+m);
        }
        // ,,, 계산 수행
    }
```
여기서 NullPointException(NPE)에 대한 내용은 기술되어 있지 않지만,<br>
BigInteger 클래스 수준에서 기술했기 때문에 이 클래스의 public 메서드 전체에 적용되기에 각 메서드에 기술 할 필요가 없다.<br>
<br>
#### java.util.Objects.requireNonNull<br>
자바 7에 추가된 메서드로 유연하고 사용하기도 편하니, 더 이상 null 검사를 수동으로 하지 않아도 된다.<br>
```java
public static <T> T requireNonNull(T obj) {
    if (obj == null)
        throw new NullPointerException();
    return obj;
}

public static <T> T requireNonNull(T obj, String message) {
    if (obj == null)
        throw new NullPointerException(message);
    return obj;
}
```
<br>

#### public이 아닌 메서드라면 단언문(assert)을 사용해 매개변수 유효성을 검증할 수 있다.
```java
public class Item49 {
    private static void solution(int[] arr, int cnt){
        assert arr != null;
        assert cnt > 0;
        System.out.println("---------");
        System.out.println("arr.length = " + arr.length);
        System.out.println("cnt = " + cnt);
        System.out.println("---------");
    }

    public static void main(String[] args) {
        solution(null, -1);
    }
}
```
<br>
<img width="40%" src="https://user-images.githubusercontent.com/55771326/170809534-41dae2d0-030a-487b-8a15-a07eb819068b.png">
<br>
<img width="40%" src="https://user-images.githubusercontent.com/55771326/170809504-ca6da5e9-14ca-4cae-b86a-bdeab35b83b6.png">
<br>

메서드나 생성자를 작성할 때면 그 매개변수들에 어떤 제약이 있을지 생각해야 한다.<br>
그 제약들을 문서화하고 메서드 코드 시작 부분에서 명시적으로 검사해야한다.<br>

## 🎯  아이템 50. 적시에 방어적 복사본을 만들라.
## 🎯  아이템 51. 메서드 시그니처를 신중히 설계하라.
## 🎯  아이템 52. 다중정의는 신중히 사용하라.
## 🎯  아이템 53. 가변인수는 신중히 사용하라.
## 🎯  아이템 54. null이 아닌, 빈 컬렉션이나 배열을 반환하라.
## 🎯  아이템 55. 옵셔널 반환은 신중히 하라.
## 🎯  아이템 56. 공개된 API 요소에는 항상 문서화 주석을 작성하라.

<br>

> Joshua Bloch, 『Effective Java 3/E』, 개앞맵시 옮김, 프로그래밍인사이트(2018), p297-342.