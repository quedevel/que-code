# 🔥 [ Chapter11 ] 동시성

## 🎯  아이템 78. 공유 중인 가변 데이터는 동기화해 사용하라.
synchronized 키워드는 해당 메서드나 블록을 한번에 한 스레드씩 수행하도록 보장한다. <br>
한 개체가 일관된 상태를 가지고 생성되고, 이 객체에 접근하는 메서드는 그 객체에 락(lock)을 건다. <br>
락을 건 메서드는 객체의 상태를 확인하고 필요하면 수정한다.<br>
즉, 객체를 하나의 일관된 상태에서 다른 일관된 상태로 변화시킨다.<br>

<br>

동기화 없이는 한 스레드가 만든 변화를 다른 스레드에서 확인하지 못할 수 있다.<br>
동기화는 일관성이 깨진 상태를 볼 수 없게 하는 것은 물론, 동기화된 메서드나 블록에 들어간<br>
스레드가 같은 락의 보호하에 수행된 모든 이전 수정의 최종 결과를 보게 해준다. <br>
**_동기화는 배타적 실행뿐 아니라 스레드 사이의 안정적인 통신에 꼭 필요하다._**

* 잘못된 코드 - 이 프로그램은 얼마나 오래 실행될까?
```java
public class StopThread {

    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested){
                i++;
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;

    }
}
```

<br>

* 적절히 동기화해 스레드가 정상 종료한다.
```java
public class StopThread {

    private static boolean stopRequested;

    private static synchronized void requestStop(){
        stopRequested = true;
    }

    private static synchronized boolean stopRequested(){
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested()){
                i++;
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
```

<br>

* `volatile` 필드를 사용해 스레드가 정상 종료한다.<br>
volatile 키워드를 추가하게 되면 메인 메모리에 저장하고 읽어오기 때문에 변수 값 불일치 문제를 해결 할 수 있습니다.<br>
```java
public class StopThread {

    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested){
                i++;
                System.out.println(i);
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
```
**_여러 스레드가 가변 데이터를 공유한다면 그 데이터를 읽고 쓰는 동작은 반드시 동기화 해야한다.**_


## 🎯  아이템 79. 과도한 동기화는 피하라.

## 🎯  아이템 80. 스레드보다는 실행자, 태스크, 스트림을 애용하라.

## 🎯  아이템 81. wait와 notify보다는 동시성 유틸리티를 애용하라.

## 🎯  아이템 82. 스레드 안전성 수준을 문서화하라.

## 🎯  아이템 83. 지연 초기화는 신중히 사용하라.

## 🎯  아이템 84. 프로그램의 동작을 스레드 스케줄러에 기대지 말라.6

<br>

> Joshua Bloch, 『Effective Java 3/E』, 개앞맵시 옮김, 프로그래밍인사이트(2018), p413-448.