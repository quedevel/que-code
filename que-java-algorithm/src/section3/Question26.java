package section3;

import java.util.*;

public class Question26 {
    public static void solution(Set<Integer> firstList, Set<Integer> secondList){
        for (Integer integer : firstList) {
            if (secondList.contains(integer)){
                System.out.print(integer + " ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        Set<Integer> firstList = new TreeSet<>();
        for (int i = 0; i < first; i++) {
            firstList.add(sc.nextInt());
        }
        int second = sc.nextInt();
        Set<Integer> secondList = new TreeSet<>();
        for (int i = 0; i < second; i++) {
            secondList.add(sc.nextInt());
        }
        solution(firstList, secondList);
    }
}