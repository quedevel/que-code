# 🔥 [ Chapter12 ] 직렬화

## 🎯  아이템 85. 자바 직렬화의 대안을 찾으라.
직렬화의 근본적인 문제는 고역ㄱ 범위가 너무 넓고 지속적으로 더 넓어져 방어하기 어렵다는 점이다.<br>
`ObjectInputStream`의 `readObject` 메서드를 호출하면서 객체 그래프가 역질렬화되기 때문이다.<br>
`readObject` 메서드는 클래스패스 안의 거의 모든 타입의 객체를 만들어 낼 수 있는, 마법같은 생성자다.<br>
바이트 스트림을 역질렬화하는 과정에서 이 메서드는 그 타입들 안의 모든 코드를 수행 할 수 있다. 이 말인 즉슨, <br>
그 타입들의 코드 전체가 공격 범위에 들어간다는 뜻이다. <br>

* 역직렬화 폭탄 - 이 스트림의 역질렬화는 영원히 계속된다. <br>
```java
public static void main(String[] args) throws Exception {
    byte[] bomb = bomb();
    System.out.println(bomb.length);
    deserialize(bomb());
}

static byte[] bomb() {
    Set<Object> root = new HashSet<>();
    Set<Object> s1 = root;
    Set<Object> s2 = new HashSet<>();
    for (int i = 0; i < 100; i++) {
        Set<Object> t1 = new HashSet<>();
        Set<Object> t2 = new HashSet<>();
        t1.add("foo"); // t1을 t2와 다르게 만든다.
        s1.add(t1);
        s1.add(t2);
        s2.add(t1);
        s2.add(t2);
        s1 = t1;
        s2 = t2;
    }
    return serialize(root);
}
```
이 객체 그래프는 201개의 `HashSet` 인스턴스로 구성되며, 그 각각은 3개 이하의 객체 참조를 갖는다. <br>
스트림의 전체 크기는 5,744바이트지만, 역직렬화는 태양이 불타 식을 때 까지도 끝나지 않을 것이다. <br>
<img width="30%" src="https://user-images.githubusercontent.com/55771326/175805319-23ebc628-223a-4100-84c6-13c197d089c1.PNG"><br>

따라서 새로운 시스템에서 자바 직렬화를 써야 할 이유는 전혀 없다. <br>

객체와 바이트 시퀀스를 변환해주는 다른 매커니즘이 많이 있다. <br>
그 크로스-플랫폼 구조화된 데이터 표현의 선두주자는 `JSON`과 `프로토콜 버퍼`다. <br>
둘의 가장 큰 차이는 `JSON`은 텍스트 기반이라 사람이 읽을 수 있고, `프로토콜 버퍼`는 이진 표현이라 효율이 훨씬 높다는 점이다. <br>
또한 `JSON`은 오직 데이터를 표현하는 데만 쓰이지만, `프로토콜 버퍼`는 문서를 위한 스키마를 제공하고 올바로 쓰도록 강요한다. <br>
효율은 `포로토콜 버퍼`가 훨씬 좋지만 텍스트 기반 표현에는 `JSON`이 아주 효과적이다. 또한, `프로토콜 버퍼`는 이진 표현뿐 아니라 <br>
사람이 읽을 수 있는 텍스트 표현도 지원한다. <br>


## 🎯  아이템 86. Serializable을 구현할지는 신중히 결정하라.

* `Serializable` 구현의 문제점 <br>

1️⃣ `Serializable`을 구현하면 릴리스한 뒤에는 수정하기 어렵다. <br>
클래스가 `Serializable`을 구현하면 직렬화된 바이트 스트림 인코딩도 하나의 공개 API가 된다.<br>
`private`과 `package-private` 인스턴스 필드들마저 API로 공개되는 꼴이 되어 캡슐화가 깨지게 된다.
<br>

2️⃣ 버그와 보안 구멍이 생길 위험이 높아진다.<br>
객체는 생성자를 사용해 만드는 게 기본이다. 즉, 직렬화는 언어의 기본 매커니즘을 우회하는 객체 생성 기법인 것이다.<br>
기반 방식을 따르든 재정의해 사용하든, 역직렬화는 일반 생성자의 문제가 그대로 적용되는 '숨은 생성자'다. 
<br>

3️⃣ 해당 클래스의 신버전을 릴리스할 때 테스트할 것이 늘어난다.<br>
직렬화 가능 클래스가 수정되면 신버전 인스턴스를 직렬화한 후 구버전으로 역직렬화할 수 있는지,<br>
그리고 그 반대도 가능한지를 검사해야 한다. 따라서 테스트해야 할 양이 직렬화 가능 클래스의 수와 릴리스 횟수에 비례해 증가한다.
<br>

`Serializable`은 구현한다고 선언하기는 아주 쉽지만, 그것은 눈속임일 뿐이다. 한 클래스의 여러 버전이 상호작용할 일이 없고 <br>
서버가 신뢰할 수 없는 데이터에 노출될 가능성이 없는 등, 보호된 환경에서만 쓰일 클래스가 아니라면 `Serializable`구현은 아주 <br>
신중하게 이뤄져야 한다. 상속할 수 있는 클래스라면 주의사항이 더욱 많아진다. <br>

## 🎯  아이템 87. 커스텀 직렬화 형태를 고려해보라.

객체의 물리적 표현과 논리적 내용이 같다면 기본 직렬화 형태라도 무방하다.
* 기본 직렬화 형태에 적합한 후보

```java
public class Name implements Serializable {
    private final String lastName;
    private final String firstName;
    private final String middleName;
    ... // 나머지 코드 생략
}
```
성명은 논리적으로 이름, 성, 중간이름이라는 3개의 문자열로 구성되며, 앞 코드의 인스턴스 필드들은 이 논리적 구성요소를 정확히 반영했다.<br>
하지만, 기본 직렬화 형태가 적합하다고 결정했더라도 불변식 보장과 보안을 위해 `readObject` 메서드를 제공해야 할 때가 많다. <br>
앞의 `Name` 클래스의 경우에는 `readObject` 메서드가 `lastName`과 `firstName` 필드가 `null`이 아님을 보장해야 한다.<br>

* 기본 직렬화 형태에 적합하지 않은 클래스
```java
public final class StringList implements Serializable {
    private int size = 0;
    private Entry head = null;

    // 이제는 직렬화되지 않는다.
    private static class Entry implements Serializable {
        String data;
        Entry next;
        Entry previous;
    }
    ... // 나머지 코드 생략
}
```

논리적으로 이 클래스는 일련의 문자열을 표현한다. 물리적으로는 문자열들을 이중 연결 리스트로 연결했다. <br>
이 클래스에 기본 직렬화 형태를 사용하면 각 노드의 양방향 연결 정보를 포함해 모든 엔트리(Entry)를 철두철미하게 기록한다. <br>
<br>
**즉, 객체의 물리적 표현과 논리적 표현의 차이가 클 때 기본 직렬화 형태를 사용하면 크게 네 가지 면에서 문제가 생긴다.**<br>
1️⃣ 공개 API가 현재의 내부 표현 방식에 영구히 묶인다. <br>
2️⃣ 너무 많은 공간을 차지할 수 있다. <br>
3️⃣ 시간이 너무 많이 걸릴 수 있다. <br>
4️⃣ 스택 오버플로를 일으킬 수 있다. <br>

<br>

그렇다면 `StringList`를 위한 합리적인 직렬화 형태는 무엇일가? <br>
단순히 리스트가 포함한 문자열의 개수를 적은 다음, 그 뒤로 문자열들을 나열하는 수준이면 될 것이다. <br>

* 합리적인 커스텀 직렬화 형태를 갖춘 StringList
```java
public final class StringList implements Serializable {
    private transient int size   = 0;
    private transient Entry head = null;
    
    private static class Entry {
        String data;
        Entry  next;
        Entry  previous;
    }

    public final void add(String s) {  }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);

        // 모든 원소를 올바른 순서로 기록한다.
        for (Entry e = head; e != null; e = e.next)
            s.writeObject(e.data);
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int numElements = s.readInt();

        for (int i = 0; i < numElements; i++)
            add((String) s.readObject());
    }
    ... // 나머지 코드는 생략
}
```

자바의 기본 직렬화 형태는 객체를 직렬화한 결과가 해당 객체의 논리적 표현에 부합할 때만 사용하고,<br>
그렇지 않으면 객체를 적절히 설명하는 커스텀 직렬화 형태를 고안하라. 직렬화 형태도 공개 메서드를 <br>
설계할 때에 준하는 시간을 들여 설계 해야 한다. 한번 공개된 메서드는 향후 릴리스에서 제거할 수 없듯이, <br>
직렬화 형태에 포함된 필드도 마음대로 제거할 수 없다. 직렬화 호환성을 유지하기 위해서 영원히 지원해야 하는 것이다. <br>


## 🎯  아이템 88. readObject 메서드는 방어적으로 작성하라.
`readObject` 메서드가 실질적으로 또 다른 public 생성자이기 때문에 다른 생성자와 똑같은 수준으로 주의를 기울여야 한다. <br>
보통의 생성자처럼 `readObject` 메서드에서도 인수가 유효한지 검사해야 하고 필요하다면 매개변수를 방어적으로 복사해야 한다. <br>
`readObject`가 이 작업을 제대로 수행하지 못하면 공격자는 아주 손쉽게 해당 클래스의 불변식을 깰 수 있다. <br>

<br>

* 가변 공격의 예
```java
public class MutablePeriod {
    public final Period period;
    public final Date start;
    public final Date end;

    public MutablePeriod() {
        try{
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);

            out.writeObject(new Period(new Date(), new Date()));

            byte[] ref = {0x71, 0, 0x7e, 0, 5};
            bos.write(ref);
            ref[4] = 4;
            bos.write(ref);

            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
            this.period = (Period) in.readObject();
            this.start = (Date) in.readObject();
            this.end = (Date) in.readObject();
        } catch (IOException | ClassNotFoundException e){
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) {
        MutablePeriod mp = new MutablePeriod();
        Period p = mp.period;
        Date pEnd = mp.end;

        pEnd.setYear(78);
        System.out.println("p = " + p);

        pEnd.setTime(69);
        System.out.println("p = " + p);
    }
}
```
```
Sun Jun 26 18:24:20 KST 2022 - Mon Jun 26 18:24:20 KST 1978
Sun Jun 26 18:24:20 KST 2022 - Thu Jan 01 09:00:00 KST 1970
```
이 예에서 `Period` 인스턴스는 불변식을 유지한 채 생성됐지만, 의도적으로 내부의 값을 수정할 수 있었다.<br>
이처럼 변경할 수 있는 `Period` 인스턴스를 획득한 공격자는 이 인스턴스가 불변이라고 가정하는 클래스에 <br>
넘겨 엄청난 보안 문제를 일으킬 수 있다.<br>

<br>

**객체를 역질렬화할 때는 클라이언트가 소유해서는 안되는 객체 참조를 갖는 필드를 모두 반드시 방어적으로 복사해야 한다.**<br>
* 방어적 복사와 유효성 검사를 수행하는 readObject 메서드
```java
private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
    s.defaultReadObject();
    this.start = new Date(start.getTime());
    this.end = new Date(end.getTime());
    if (start.compareTo(end)>0){
        throw new InvalidObjectException(start + "가 " + end + "보다 늦다.");
    }
}
```
```
Sun Jun 26 18:31:31 KST 2022 - Sun Jun 26 18:31:31 KST 2022
Sun Jun 26 18:31:31 KST 2022 - Sun Jun 26 18:31:31 KST 2022
```

* readObject 메서드를 작성하는 지침
1. private이어야 하는 객체 참조 필드는 각 필드가 가리키는 객체를 방어적으로 복사하라.
2. 모든 불변식을 검사하여 어글나는 게 발견되면 InvalidObjectException을 던진다.
3. 역질렬화 후 객체 그래프 전체의 유효성을 검사해야 한다면 ObjectInputValidation 인터페이스를 사용하라
4. 직접적이든 간접적이든, 재정의할 수 있는 메서드는 호출하지 말자.

<br>


## 🎯  아이템 89. 인스턴스 수를 통제해야 한다면 readResolve보다는 열거 타입을 사용하라.
## 🎯  아이템 90. 직렬화된 인스턴스 대신 직렬화 프록시 사용을 검토하라.

<br>

> Joshua Bloch, 『Effective Java 3/E』, 개앞맵시 옮김, 프로그래밍인사이트(2018), p449-482.