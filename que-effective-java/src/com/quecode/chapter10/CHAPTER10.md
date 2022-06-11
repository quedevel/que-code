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
## 🎯  아이템 72. 표준 예외를 사용하라.
## 🎯  아이템 73. 추상화 수준에 맞는 예외를 던지라.
## 🎯  아이템 74. 메서드가 던지는 모든 예외를 문서화하라.
## 🎯  아이템 75. 예외의 상세 메시지에 실패 관련 정보를 담으라.
## 🎯  아이템 76. 가능한 한 실패 원자적으로 만들라.
## 🎯  아이템 77. 예외를 무시하지 말라.

<br>

> Joshua Bloch, 『Effective Java 3/E』, 개앞맵시 옮김, 프로그래밍인사이트(2018), p385-411.