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
## 🎯  아이템 87. 커스텀 직렬화 형태를 고려해보라.
## 🎯  아이템 88. readObject 메서드는 방어적으로 작성하라.
## 🎯  아이템 89. 인스턴스 수를 통제해야 한다면 readResolve보다는 열거 타입을 사용하라.
## 🎯  아이템 90. 직렬화된 인스턴스 대신 직렬화 프록시 사용을 검토하라.

<br>

> Joshua Bloch, 『Effective Java 3/E』, 개앞맵시 옮김, 프로그래밍인사이트(2018), p449-482.