package com.quecode.chapter6;

import com.quecode.chapter6.model.Order;
import com.quecode.chapter6.model.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 6.1 Stream
 * 6.2 Filter
 * 6.3 Map
 * 6.4 Stream의 구성 요소
 * 6.5 데이터 정렬
 * 6.6 중복제거
 * 6.7 FlatMap
 */
public class Chapter6 {

    public static void main(String[] args) {
        /**
         * 6.1 Stream
         */
        Stream<String> nameStream = Stream.of("Alice", "Bob", "Charlie");
        List<String> names = nameStream.collect(Collectors.toList());
        System.out.println("names = " + names);

        String[] cityArray = new String[]{"San Jose", "Seoul", "Tokyo"};
        Stream<String> cityStream = Arrays.stream(cityArray);
        List<String> cityList = cityStream.collect(Collectors.toList());
        System.out.println("cityList = " + cityList);

        Set<Integer> numberSet = new HashSet<>(Arrays.asList(3,5,7));
        Stream<Integer> numberStream = numberSet.stream();
        List<Integer> numberList = numberStream.collect(Collectors.toList());
        System.out.println("numberList = " + numberList);

        System.out.println();
        System.out.println();

        /**
         * 6.2 Filter
         */
        Stream<Integer> integerStream = Stream.of(3,-5,7,10,-3);
        Stream<Integer> filteredIntegerStream1 = integerStream.filter(x -> x > 0);
        List<Integer> filteredIntegers = filteredIntegerStream1.collect(Collectors.toList());
        System.out.println("filteredIntegers = " + filteredIntegers);

        List<Integer> filteredIntegers2 = Stream.of(3,-5,7,10,-3).filter(x -> x>0).collect(Collectors.toList());
        System.out.println("filteredIntegers2 = " + filteredIntegers2);

        User user1 = new User().setId(101).setName("Alice").setVerified(true).setEmailAddress("alice@innotree.com");
        User user2 = new User().setId(102).setName("Bob").setVerified(false).setEmailAddress("bob@innotree.com");
        User user3 = new User().setId(103).setName("Charlie").setVerified(false).setEmailAddress("charlie@innotree.com");

        List<User> verifiedUsers = Arrays.asList(user1, user2, user3).stream().filter(User::isVerified).collect(Collectors.toList());
        System.out.println("검증된 유저");
        verifiedUsers.forEach(System.out::println);

        List<User> unverifiedUsres = Arrays.asList(user1, user2, user3).stream().filter(user -> !user.isVerified()).collect(Collectors.toList());
        System.out.println("검증되지 않은 유저");
        unverifiedUsres.forEach(System.out::println);

        Order order1 = new Order().setId(1001).setStatus(Order.OrderStatus.CREATED).setCreatedByUserId(101);
        Order order2 = new Order().setId(1002).setStatus(Order.OrderStatus.ERROR).setCreatedByUserId(102);
        Order order3 = new Order().setId(1003).setStatus(Order.OrderStatus.IN_PROGRESS).setCreatedByUserId(103);
        Order order4 = new Order().setId(1004).setStatus(Order.OrderStatus.PROCESSED).setCreatedByUserId(104);
        Order order5 = new Order().setId(1005).setStatus(Order.OrderStatus.ERROR).setCreatedByUserId(105);

        List<Order> filteredOrders = Arrays.asList(order1,order2,order3,order4,order5).stream().filter(order -> order.getStatus() == Order.OrderStatus.ERROR).collect(Collectors.toList());
        System.out.println("ERROR 상태인 주문");
        System.out.println("filteredOrders = " + filteredOrders);
        System.out.println();
        System.out.println();

        /**
         * 6.3 Map
         */
        List<Integer> integers = Arrays.asList(3,6,-4).stream().map(x -> x * 2).collect(Collectors.toList());
        System.out.println("integers = " + integers);

        List<String> strings = Arrays.asList(3,6,-4).stream().map(x -> "Number is "+x).collect(Collectors.toList());
        System.out.println("strings = " + strings);

        List<String> emails = Arrays.asList(user1, user2, user3).stream().map(User::getEmailAddress).collect(Collectors.toList());
        System.out.println("emails = " + emails);

        List<Long> userIds = Arrays.asList(order1,order2,order3,order4,order5).stream().map(Order::getCreatedByUserId).collect(Collectors.toList());
        System.out.println("userIds = " + userIds);
    }
}
