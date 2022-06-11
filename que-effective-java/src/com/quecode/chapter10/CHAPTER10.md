# 🔥 [ Chapter10 ] 예외
<br>
<img width="50%" src="https://user-images.githubusercontent.com/55771326/173170097-a51d0e68-e4c0-4d5f-bb83-72551470e57a.png">


## 🎯  아이템 69. 예외는 진짜 예외 상황에만 사용하라.
* 예외를 완전히 잘못 사용한 예 - 따라 하지 말 것!
```java
try{
    int i = 0;
    while(true)
        range[i++].climb();
} catch (ArrayIndexOutOfBoundsException e){
}
```
위 코드는 무한루프를 돌다가 배열의 끝에 도달해 `ArrayIndexOutOfBoundsException`이 발생하면 끝을 내는 것이다.<br>
하지만 표준적인 관용구인 `for-each`로 작성했다면 더 이해하기 쉽다.<br>
```java
for(Mountaion m : range)
    m.climb();
```
그런데 예외를 써서 루프를 종료한 이유는 뭘까? <br>
그 이유는 잘못된 추론을 근거로 성능을 높여보려 한 것이다. JVM은 배열에 접근할 때마다 경계를 넘지 않는지 검사하는데,<br>
일반적인 반복문도 배열 경계에 도달하면 종료한다. 따라서 이 검사를 반복문에도 명시하면 같은 일이 중복되므로 하나를 <br>
생략한 것이다. <br>

* 하지만 세 가지 면에서 잘못된 추론이다.
1. 예외는 예외 상황에 쓸 용도로 설계되었으므로 JVM 구현자 입장에서는 명확한 검사만큼 빠르게 만들어야 할 동기가 약하다.
2. 코드를 `try-catch` 블록 안에 넣으면 JVM이 적용할 수 있는 최적화가 제한된다.
3. 배열을 순회하는 표준 관용구는 앞서 걱정한 중복 검사를 수행하지 않는다. JVM이 알아서 최적화해 없애준다.

<span style="color: red;">실상은 예외를 사용한 쪽이 표준 관용구보다 훨씬 느리다.</span><br>
또한, 반복문의 몸체에서 호출한 메서드가 내부에서 관련 없는 배열을 사용하다가 `ArrayIndexOutOfBoundsException`을 일으켰다고 해보면, <br>
표준 관용구였다면 이 버그는 예외를 잡지 않고 해당 스레드를 즉각 종료시킬 것이다. <br>
<span style="color: red;">반면 예외를 사용한 반복문은 버그 때문에 발생한 엉뚱한 예외를 정상적인 반복문 종료 상황으로 오해하고 넘어간다.</span> <br>
따라서, 예외는 오직 예외 상황에서만 써야 한다. 절대로 일상적인 제어 흐름용으로 쓰여선 안 된다. <br>

## 🎯  아이템 70. 복구할 수 있는 상황에는 검사 예외를, 프로그래밍 오류에는 런타입 예외를 사용하라.
* 호출하는 쪽에서 복구하리라 여겨지는 상황이라면 검사 예외를 사용하라.
```java
/**
 * 메뉴 등록
 * @param menuVO
 * @throws Exception
 */
public void insertMenu(MenuVO menuVO) throws SQLException{
    menuVO.setMenuSn(menuSnIdService.getNextStringId());
    int dept = 1;
    if(CommonConstants.INNO_ROOT_SN.getValue().equals(menuVO.getSupiMenuSn())){
        menuVO.setDept(dept);
    } else {
        menuVO.setDept(menuMapper.selectDeptBySupiMenuSn(menuVO)+1);
    }
    menuMapper.insertAdminMenu(menuVO);
}
```
위 코드는 메뉴를 등록하는 함수로 호출하는쪽에서 복구(트랜잭션 처리)를 할 것이기 때문에 검사 예외인 `SQLException`을 사용했다. <br>

<br>

* 프로그래밍 오류를 나타낼 때는 런타임 예외를 사용하자.
```java
private void validateDuplicateMember(Member member) {
    List<Member> findMembers = memberRepository.findByName(member.getName());
    if (!findMembers.isEmpty()){
        throw new IllegalStateException("이미 존재하는 회원입니다.");
    }
}
```
위 코드는 회원 중복 검사를 하는 함수로 클라이언트에서 API 명세의 규약을 지키지 못하여 발생하는 예외이므로 적절한 메시지와 함께 중단시킨다. <br>

<br>

검사 예외도 아니고 런타임 예외도 아닌 `throwable`은 정의하지도 말자. 오히려 개발자들을 헷갈리게할 뿐이다. <br>
검사 예외라면 복구에 필요한 정보를 알려주는 메서드도 제공하자.<br>

## 🎯  아이템 71. 필요 없는 검사 예외 사용은 피하라.
결과를 코드로 반환하거나 비검사 예외를 던지는것과 달리, 검사 예외는 발생한 문제를 프로그래머가 처리하여 안전성을 높이게끔 해준다.<br>
물론, 검사 예외를 과하게 사용하면 오히려 쓰기 불편한 API가 된다. 어떤 메서드가 검사 예외를 던질 수 있다고 선언됐다면,<br> 
<span style="color: red;">이를 호출하는  코드에서는 `catch` 블록을 두어 그 예외를 붙잡아 처리하거나 더 바깥으로 던져 문제를 전파해야만 한다.</span><br> 
어느 쪽이든 API 사용자에게 부담을 준다. <span style="color: red;">더구나 검사 예외를 던지는 메서드는 스트림 안에서 직접 사용할 수 없기 때문에 자바 8부터는 부담이 더욱 커졌다.</span><br>
```java
public class Main {
    public static void main(String[] args) {
        try {
            extracted();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void extracted() throws IOException {
        byte[] bytes = {'a','b','c'};
        System.out.write(bytes);
    }
}
```
<br>
<img width="40%" src="https://user-images.githubusercontent.com/55771326/173170964-51ee6b5c-6690-4b2c-869b-e4647d4a4c40.png">
<br>
<img width="40%" src="https://user-images.githubusercontent.com/55771326/173171121-6b8ecebd-4db8-40d6-82df-654333e669a8.png">
<br>
검사 예외를 회피하는 가장 쉬운 방법은 적절한 결과 타입을 담은 옵셔널을 반환하는 것이다. 이 방식의 단점이라면 <br>
예외가 발생한 이유를 알려주는 부가 정보를 담을 수 없다는 것이다. 또 다른 방법으로, 검사 예외를 던지는 메서드를 2개로 쪼개 <br>
비검사 예외로 바꿀 수 있다. 하지만 이것 또한 모든 상황에 적용할 수는 없다. 그래도 적용할 수만 있다면 더 쓰기 편한 API를 제공할 수 있다.<br>

## 🎯  아이템 72. 표준 예외를 사용하라.
숙련된 프로그래머는 그렇지 못한 프로그래머보다 더 많은 코드를 재사용한다. 예외도 마찬가지로 재사용하는 것이 좋으며, <br>
자바 라이브러리는 대부분 API에서 쓰기에 충분한 수의 예외를 제공한다. 하지만 어떤 예외를 사용해야할지 모른다고하여 <br>
`Exception`, `RuntimeException`, `Throwable`, `Error`는 직접 재사용하지는 말자.<br>

| 예외                              | 주요 쓰임                          |
|---------------------------------|--------------------------------             |
| IllegalArgumentException        | 허용하지 않는 값이 인수로 건네졌을 때          |
| IllegalStateException           | 객체가 메서드를 수행하기에 적절하지 않은 상태일 때   |
| NullPointerException            | null을 허용하지 않는 메서드에 null을 건넸을 때 |
| IndexOutOfBoundsException       | 인덱스가 범위를 넘어섰을 때                |
| ConcurrentModificationException | 허용하지 않는 동시 수정이 발견됐을 때          |
| UnsupportedOperationException   | 호출한 메서드를 지원하지 않을 때             |


## 🎯  아이템 73. 추상화 수준에 맞는 예외를 던지라.
수행하려는 일과 관련 없어 보이는 예외가 튀어나오면 당황스러울 것이다. 메서드가 저수준 예외를 처리하지 않고 <br>
바깥으로 전파해버릴 때 종종 일어나는 일이다. 사실 이는 단순히 프로그래머를 당황시키는 데 그치지 않고, 내부 구현 방식을 <br>
드러내어 윗 레벨 API를 오염시킨다. 다음 릴리스에서 구현 방식을 바꾸면 다른 예외가 튀어나와 기존 클라이언트 프로그램을 <br>
깨지게 할 수도 있는 것이다. 이 문제를 피하려면 <span style="color: red;">상위 계층에서는 저수준 예외를 잡아 자신의 추상화 수준에 맞는 예외로 바꿔 <br>
던져야 한다.</span> 이를 예외 번역(exception translation)이라 한다. <br>
<img width="40%" src="https://user-images.githubusercontent.com/55771326/173171823-4abba268-2d9a-43f0-b245-c7280c2594dd.png">

## 🎯  아이템 74. 메서드가 던지는 모든 예외를 문서화하라.
메서드가 던지는 예외는 그 메서드를 올바로 사용하는 데 아주 중요한 정보다. 따라서 각 메서드가 던지는 예외 하나하나를 문서화하는 데 <br>
충분한 시간을 쏟아야 한다. <span style="color: red;">검사 예외는 항상 따로따로 선언하고, 각 예외가 발생하는 상황을 자바독의 `@throws` 태그를 사용하여 정확히 문서화하자.</span><br>

```java
/**
 * ... 생략
 *
 * @throws  SecurityException if a security manager exists and its
 *          <code>checkPermission</code> method denies enabling
 *          subclassing.
 * @throws  IOException if an I/O error occurs while creating this stream
 *
 */
protected ObjectInputStream() throws IOException, SecurityException { ... }
```
검사 예외만 메서드 선언의 throws 문에 일일이 선언하고, 비검사 예외는 메서드 선언에는 기입하지 말자. <br>
발생 가능한 예외를 문서로 남기지 않으면 다른 사람이 그 클래스나 인터페이스를 효과적으로 사용하기 어렵거나 <br>
심지어 불가능할 수도 있다. <br>

## 🎯  아이템 75. 예외의 상세 메시지에 실패 관련 정보를 담으라.
## 🎯  아이템 76. 가능한 한 실패 원자적으로 만들라.
## 🎯  아이템 77. 예외를 무시하지 말라.

<br>

> Joshua Bloch, 『Effective Java 3/E』, 개앞맵시 옮김, 프로그래밍인사이트(2018), p385-411.