# 🔥 [ Chapter9 ] 일반적인 프로그래밍 원칙

## 🎯  아이템 57. 지역변수의 범위를 최소화하라.
지역변수의 유효 범위를 최소로 줄이면 코드 가독성과 유지보수성이 높아지고 오류 가능성은 낮아진다.

### ⭐ 지역변수의 범위를 줄이는 가장 강력한 기법 <br>

####1️⃣ 가장 처음 쓰일 때 선언하기<br>
```java
public class Main {
    public static void main(String[] args) {
        int scope = 0;

        /* main메서드가 완료될 때까지 scope변수는 살아있다. */
    }
}
```
변수를 항상 최상단에 선언하는 버릇을 가진 개발자가 존재한다. <br>
하지만 그건 변수의 범위를 메소드의 모든 범위에 속하게 하며 가독성마저 떨어지게 만드는 행위다.<br>
<br>

####2️⃣ 거의 모든 지역변수는 선언과 동시에 초기화해야 한다.<br>
초기화할 정보가 부족하다면 정보가 충분해질때까지 `선언`을 미루자. <br>
하지만 `try-catch`문의 경우 초기화시 예외가 발생할 경우는 블록 안에서 초기화 하자<br>
```java
/**
 * 코드 children 조회
 * @param supiCdId
 * @return
 */
public static List<CodeVO> getCodeChildren(String supiCdId) throws Exception {
    List<CodeVO> result = new ArrayList<>();
    CodeService codeService = null;
    try {
        codeService = (CodeService) ApplicationContextProvider.getContext().getBean("codeService");
        result = codeService.getCodeChildren(supiCdId);
        return result;
    } catch (Exception e){
        return result;
   }
}
```
<br>

####3️⃣ 메서드를 작게 유지하고 한 가지 기능에 집중하는 것이다.<br>

## 🎯  아이템 58. 전통적인 for 문보다는 for-each 문을 사용하라.
전통적인 `for`문과 비교했을 때 `for-each`문은 명료하고, 유연하고, 버그를 예방해준다.<br>
성능 저하도 없다. 가능한 모든 곳에서 `for`문이 아닌 `for-each`문을 사용하자.<br>

<br>

#### 하지만 안타깝게도 `for-each`문을 사용할 수 없는 상황이 세 가지 존재한다.<br>

1️⃣ **파괴적인 필터링** <br>
컬렉션을 순회하면서 선택된 원소를 제거해야 한다면 반복자의 remove 메서드를 호출해야한다. <br>
자바8부터는 Collection의 removeIf 메서드를 사용해 컬렉션을 명시적으로 순회하는 일을 피할 수 있다.<br>

<br>

2️⃣ **변형** <br>
리스트나 배열을 순회하면서 그 원소의 값 일부 혹은 전체를 교체해야 한다면 리스트의 반복자나<br>
배열의 인덱스를 사용해야한다.<br>

<br>

3️⃣ **병렬 반복** <br>
여러 컬렉션을 병렬로 순회해야 한다면 각각의 반복자와 인덱스 별수를 사용해 엄격하고 <br>
명시적으로 제어해야 한다.

## 🎯  아이템 59. 라이브러리를 익히고 사용하라.
#### **_“바퀴를 다시 발명하지 마라 (Don’t reinvent the wheel)”_** <br>
<br>
아주 특변한 나만의 기능이 아니라면 누군가 이미 라이브러리 형태로 구현해놓았을 가능성이 크다.<br>

<br>

* 표준 라이브러리를 사용하면 좋은 이점
1. 코드를 작성한 전문가의 지식과 여러분보다 앞서 사용한 다른 프로그래머들의 경험을 활용할 수 있다.
2. 핵심적인 일과 크게 관련 없는 문제를 해결하느라 시간을 허비하지 않아도 된다는 것이다.
3. 노력하지 않아도 성능이 지속해서 개선된다는 점이다.
4. 기능이 점점 더 많아진다.
5. 작성한 코드가 많은 사람에게 낯익은 코드가 된다.

<br>

## 🎯  아이템 60. 정확한 답이 필요하다면 float와 double은 피하라.
`float`와 `double` 타입은 과학과 공학 계산용으로 설계되었다. 이진 부동소수점 연산에 쓰이며,<br>
넓은 범위의 수를 빠르게 정밀한 '근사치'로 계산하도록 세심하게 설계되었다. 따라서, 정확한<br>
결과가 필요할 때는 사용하면 안 된다.<br>
`float`와 `double` 타입은 특히 금융 관련 계산과는 맞지 않는다.<br>
따라서, 금융 계산에는 `BigDecimal`, `int` 혹은 `long`을 사용해야 한다.<br>

## 🎯  아이템 61. 박싱된 기본 타입보다는 기본 타입을 사용하라.
### 기본 타입 vs 박싱된 기본 타입
1️⃣ 기본 타입은 값만 가지고 있으나, 박싱된 기본 타입은 값에 더해 식별성이란 속성을 갖는다.<br>
```java
public class Main {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        System.out.println("(b == a) : " + (b == a)); // (b == a) : true
        Integer boxedIntegerA = new Integer(1);
        Integer boxedIntegerB = new Integer(1);
        System.out.println("(boxedIntegerB == boxedIntegerA) : " + (boxedIntegerB == boxedIntegerA)); // (boxedIntegerB == boxedIntegerA) : false
        System.out.println("boxedIntegerB.equals(boxedIntegerA) : " + boxedIntegerB.equals(boxedIntegerA)); // boxedIntegerB.equals(boxedIntegerA) : true
    }
}
```
<br>

2️⃣  기본 타입의 값은 언제나 유효하나, 박싱된 기본 타입은 유효하지 않은 값, 즉 null을 가질 수 있다.<br>
```java
public class Main {
    static int a;
    static Integer i;
    public static void main(String[] args) {
        if (a < 1) System.out.println(a);
        if (i < 1) System.out.println(i);
    }
}
```
<br>
<img width="40%" src="https://user-images.githubusercontent.com/55771326/171981822-83965121-0557-4805-929d-7331583f2c36.png" >

<br>

3️⃣  기본 타입이 박싱된 기본 타입보다 시간과 메모리 사용면에서 더 효율적이다. <br>

## 🎯  아이템 62. 다른 타입이 적절하다면 문자열 사용을 피하라.
1️⃣ 문자열은 다른 값 타입을 대신하기에 적합하지 않다. <br>
받는 데이터가 수치형이라면 int, float, BigInteger 등 적당한 수치 타입으로 변한해야한다.<br>
'예/아니오' 질문의 답이라면 적절한 열거 타입이나 boolean으로 변환해야 한다.<br>

2️⃣ 문자열은 열거 타입을 대신하기에 적합하지 않다. <br>

3️⃣ 문자열은 혼합 타입을 대신하기에 적합하지 않다. <br>
* 혼합 타입을 문자열로 처리한 부적절한 예 <br>
```java
String compoundKey = className + "#" + i.next();
```

4️⃣ 문자열은 권한을 표현하기에 적합하지 않다. <br>
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
public enum RoleType {
    USER, ADMIN;
}
```
~~private String roleType~~ 은 권한에 적합하지 않다. <br>

<br>

## 🎯  아이템 63. 문자열 연결은 느리니 주의하라.
#### **_문자열 연결 연산자로 문자열 n개를 잇는 시간은 n^2에 비례한다._**
* 문자열 연결을 잘못 사용한 예 - 느리다!
```java
public String statement(){
    String result = "";
    for(int i = 0; i < numItems(); i++)
        result += lineForItem(i);
    return result;
}
```
품목이 많을 경우 이 메서드는 심각하게 느려질 수 있다. <br>
성능을 포기하고 싶지 않다면 `String` 대신 `StringBuilder`를 사용하자.

* StringBuilder를 사용하면 문자열 연결 성능이 크게 개선된다.
```java
public String statement2(){
    StringBuilder b = new StringBuilder(numItems() * LINE_WIDTH);
    for(int i = 0; i < numItems(); i++)
        b.append(lineForItem(i));
    return b.toString();
}
```

## 🎯  아이템 64. 객체는 인터페이스를 사용해 참조하라.
## 🎯  아이템 65. 리플렉션보다는 인터페이스를 사용하라.
## 🎯  아이템 66. 네이티브 메서드는 신중히 사용하라.
## 🎯  아이템 67. 최적화는 신중히 하라.
## 🎯  아이템 68. 일반적으로 통용되는 명명 규칙을 따르라.

<br>

> Joshua Bloch, 『Effective Java 3/E』, 개앞맵시 옮김, 프로그래밍인사이트(2018), p343-384.