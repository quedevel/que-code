# 🔥 [ Chapter7 ] 람다와 스트림

## 🎯  아이템 42. 익명 클래스보다는 람다를 사용하라.
예전에는 자바에서 함수 타입을 표현할 때 추상 메서드를 하나만 담은 인터페이스를 사용했다.<br>
이런 인터페이스의 인스턴스를 함수객체라고 하여, 특정 함수나 동작을 나타내는 데 썼다.<br>

<br>

* 익명 클래스의 인스턴스를 함수 객체로 사용 - 낡은 기법이다!
```java
public class Item43 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("test3");
        list.add("te2st3");
        list.add("test4");
        list.add("5test3");
        
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        list.forEach(System.out::println);
    }
}
```
전략 패턴처럼, 함수 객체를 사용하는 과거 객체 지향 디자인 패턴에는 익명 클래스면 충분했다.

<br>

자바8에 와서 추상 메서드 하나짜리 인터페이스는 특별한 의미를 인정받아 특별한 대우를 받게 되었다.<br>
지금은 함수형 인터페이스라 부르는 이 인터페이스들의 인스턴스를 람다식을 사용해 만들 수 있게 된 것이다.<br>

<br>

* 람다식을 함수 객체로 사용 - 익명 클래스 대체
```java
public class Item43 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("test3");
        list.add("te2st3");
        list.add("test4");
        list.add("5test3");

        // 1
        Collections.sort(list, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        
        // 2
        Collections.sort(list, comparingInt(String::length));
        
        // 3 
        list.sort(comparingInt(String::length));

        list.forEach(System.out::println);
    }
}
```
**_타입을 명시해야 코드가 더 명확할 때만 제외하고는, 람다의 모든 매개변수 타입은 생략하자._** <br>

<br>

> 람다는 이름이 없고 문서화도 못한다. 따라서 코드 자체로 동작이 명확히 설명되지 않거나 코드 줄 수가 많아지면 람다를 쓰지 말아야 한다. <br>

<br>

## 🎯  아이템 43. 람다보다는 메서드 참조를 사용하라.
람다가 익명 클래스보다 나은 점 중에서 가장 큰 특징은 간결함이다. 그런데 자바에는 함수 객체를 심지어 람다보다도 <br>
더 간결하게 만드는 방법이 있으니, 바로 메서드 참조다. 하지만, 메서드 참조 쪽이 짧고 명확하다면 메서드 참조를 쓰고, <br>
그렇지 않을 때만 람다를 사용하라.<br>

<br>


* 메서드 참조를 사용했을때 더 짧고 명확한 소스
```java
List<Long> sortedOrders = orders.stream()
        .sorted(comparing(Order::getCreatedAt))
        .map(Order::getId)
        .collect(Collectors.toList());
```
좀 더 짧고 명확한 소스가 되었다. 하지만, 클래스명이 너무 길거나 더 명확하다고 판단되지 않는다면 람다를 사용하자.

## 🎯  아이템 44. 표준 함수형 인터페이스를 사용하라.
**_필요한 용도에 맞는 게 있다면, 직접 구현하지 말고 표준 함수형 인터페이스를 활용하라._**<br>
```java
public class Item44 {
    public static void main(String[] args) {

        /**
         * 1 Supplier
         */
        Supplier<String> supplier = () -> "hello world";
        System.out.println("supplier = " + supplier.get());

        Supplier<Double> doubleSupplier = () -> Math.random();
        System.out.println("doubleSupplier = " + doubleSupplier.get());

        printRandomDoubles(doubleSupplier, 5);

        System.out.println();

        /**
         * 2 Consumer
         */
        Consumer<String> stringConsumer = str -> System.out.println(str);
        stringConsumer.accept("Hell World");

        Consumer<Integer> integerConsumer = x -> System.out.println("Processing Integer " + x);
        List<Integer> integerList = Arrays.asList(4,2,3);

        process(integerList, integerConsumer);
        System.out.println();

        /**
         * 3 BiConsumer
         */
        BiConsumer<Integer, Double> doubleBiConsumer = (index, input) -> System.out.println("Processing " + input+" at index "+index);
        List<Double> doubleList = Arrays.asList(4.1,2.2,3.3);

        process(doubleList, doubleBiConsumer);
        System.out.println();

        /**
         * 4 Predicate
         */
        Predicate<Integer> integerPredicate = x -> x>0;
        System.out.println(integerPredicate.test(2));

        List<Integer> inputs = Arrays.asList(10,-5,-2,0,3);
        System.out.println("filter(inputs, integerPredicate) = " + filter(inputs, integerPredicate));
        System.out.println("filter(inputs, integerPredicate.negate()) = " + filter(inputs, integerPredicate.negate()));
        System.out.println("filter(inputs, integerPredicate.or(x-> x==0)) = " + filter(inputs, integerPredicate.or(x-> x==0)));
        System.out.println("filter(inputs, integerPredicate.and(x-> x%2 == 0)) = " + filter(inputs, integerPredicate.and(x-> x%2 == 0)));
        System.out.println();

        /**
         * 5 Comparator
         */
        List<User> users = new ArrayList<>();
        users.add(new User(3, "Alice"));
        users.add(new User(1, "Charlie"));
        users.add(new User(5, "Bob"));
        System.out.println("users = " + users);

        Comparator<User> idComparator = Comparator.comparingInt(User::getId);
        Collections.sort(users, idComparator);
        System.out.println("users = " + users);

        Collections.sort(users, Comparator.comparing(User::getName));
        System.out.println("users = " + users);
    }

    public static void printRandomDoubles(Supplier<Double> randomSupplier, int count){
        for (int i = 0; i < count; i++){
            System.out.println(randomSupplier.get());
        }
    }

    public static <T> void process(List<T> inputs, Consumer<T> processor){
        for (T input : inputs){
            processor.accept(input);
        }
    }

    public static <T> void process(List<T> inputs, BiConsumer<Integer, T> processor){
        for (int i = 0; i < inputs.size(); i++) {
            processor.accept(i, inputs.get(i));
        }
    }

    public static <T> List<T> filter(List<T> inputs, Predicate<T> condition){
        List<T> output = new ArrayList<>();
        for (T t : inputs) {
            if(condition.test(t)){
                output.add(t);
            }
        }
        return output;
    }

    static class User {
        private int id;
        private String name;
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public int getId() {return id;}
        public void setId(int id) {this.id = id;}
        public String getName() {return name;}
        public void setName(String name) {this.name = name;}
        @Override
        public String toString() {return "User{" + "id=" + id + ", name='" + name + '\'' + '}';}
    }
}
```
위는 표준 함수형 인터페이스를 활용한 간단한 예제이다. <br>

<br>

하지만, 표준 함수형 인터페이스가 지원하지 않는 기능을 만들고자 한다면 반드시 `@FuntionalInterface`를 사용하자. <br>
이 애너테이션을 사용하는 이유는 `@Override`를 사용하는 이유와 비슷하다.
1. 해당 클래스의 코드나 설명 문서를 읽을 이에게 그 인터페이스가 람다용으로 설계된 것임을 알려준다.
2. 해당 인터페이스가 추상 메서드를 오직 하나만 가지고 있어야 컴파일되게 해준다.
3. 그 결과 유지보수 과정에서 누군가 실수로 메서드를 추가하지 못하게 막아준다.

## 🎯  아이템 45. 스트림은 주의해서 사용하라.
## 🎯  아이템 46. 스트림에서는 부작용 없는 함수를 사용하라.
## 🎯  아이템 47. 반환 타입으로는 스트림보다 컬렉션이 낫다.
## 🎯  아이템 48. 스트림 병렬화는 주의해서 적용하라.

<br>

> Joshua Bloch, 『Effective Java 3/E』, 개앞맵시 옮김, 프로그래밍인사이트(2018), p207-251.