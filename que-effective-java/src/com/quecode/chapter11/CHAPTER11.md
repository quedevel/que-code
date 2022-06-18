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
**_응답 불가와 안전 실패를 피하려면 동기화 메서드나 동기화 블록 안에서는 제어를 절대로 클라이언트에 양도하면 안된다._** <br>
동기화된 영역을 포함한 클래스 관점에서는 이런 메서드는 모두 바깥 세상에서 온 외계인이므로 예측할 수 없는 이슈를 발생 시킨다 <br>

* 잘못된 코드. 동기화 블록 안에서 외계인 메서드를 호출한다.
```java
public class ObservableSet<E> extends ForwardingSet<E> {
    public ObservableSet(Set<E> set) { super(set); }

    private final List<SetObserver<E>> observers = new ArrayList<>();

    public void addObserver(SetObserver<E> observer) {
        synchronized(observers) {
            observers.add(observer);
        }
    }

    public boolean removeObserver(SetObserver<E> observer) {
        synchronized(observers) {
            return observers.remove(observer);
        }
    }

    private void notifyElementAdded(E element) {
        synchronized(observers) {
            for (SetObserver<E> observer : observers)
                observer.added(this, element);
        }
    }

    @Override 
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added)
            notifyElementAdded(element);
        return added;
    }
}
```
```java
public static void main(String[] args) {
    ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

    set.addObserver(new SetObserver<>() {
        public void added(ObservableSet<Integer> s, Integer e) {
            System.out.println(e);
            if (e == 23) // 값이 23이면 자신을 구독해지한다.
                s.removeObserver(this);
        }
    });

    for (int i = 0; i < 100; i++)
        set.add(i);
}
```
이 프로그램은 23까지 출력한 다음 `ConcurrentModificationException`을 던진다. <br>
`added` 메서드 호출이 일어난 시점이 `notifyElementAdded`가 관찰자들의 리스트를 순회하는 도중이기 때문이다. <br>

* 쓸데없이 백그라운드 스레드를 사용하는 관찰자
```java
public static void main(String[] args) {
    ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

    set.addObserver(new SetObserver<>() {
        public void added(ObservableSet<Integer> s, Integer e) {
            System.out.println(e);
            if (e == 23) {
                ExecutorService exec = Executors.newSingleThreadExecutor();
                try {
                    exec.submit(() -> s.removeObserver(this)).get();
                } catch (ExecutionException | InterruptedException ex) {
                    throw new AssertionError(ex);
                } finally {
                    exec.shutdown();
                }
            }
        }
    });

    for (int i = 0; i < 100; i++)
        set.add(i);
}
```
이 프로그램을 실행하면 예외는 나지 않지만 교착상태에 빠진다.<br>

* 해결책 1 외계인 메서드 호출을 동기화 블록 바깥으로 옮긴다.
```java
private void notifyElementAdded(E element) {
    List<SetObserver<E>> snapshot = null;
    synchronized(observers) {
        snapshot = new ArrayList<>(observers);
    }
    for (SetObserver<E> observer : snapshot)
        observer.added(this, element);
}
```
<br>

* 해결책 2 `CopyOnWriteArrayList`를 사용해 구현한 스레드 안전하고 관찰 가능한 집합
```java
private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<>();
```

<br>

**_기본 규칙은 동기화 영역에서는 가능한 한 일을 적게 하는 것이다._**<br>

* 가변 클래스를 작성하려거든 다음 두 선택지 중 하나를 따르자.
#### 1.동기화를 하지말고, 클래스를 동시에 사용해야 하는 클래스가 외부에서 동기화도록 하자.
#### 2.동기화를 내부에서 수행해 스레드 안전한 클래스로 만들자.
1️⃣ 락 분할(lock splitting) <br>
2️⃣ 락 스트라이이핑(lock striping) <br>
3️⃣ 비차단 동시성 제어(nonblocking concurrency control) <br>

## 🎯  아이템 80. 스레드보다는 실행자, 태스크, 스트림을 애용하라.

## 🎯  아이템 81. wait와 notify보다는 동시성 유틸리티를 애용하라.

## 🎯  아이템 82. 스레드 안전성 수준을 문서화하라.

## 🎯  아이템 83. 지연 초기화는 신중히 사용하라.

## 🎯  아이템 84. 프로그램의 동작을 스레드 스케줄러에 기대지 말라.6

<br>

> Joshua Bloch, 『Effective Java 3/E』, 개앞맵시 옮김, 프로그래밍인사이트(2018), p413-448.