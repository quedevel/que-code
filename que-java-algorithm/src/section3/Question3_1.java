package section3;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Question3_1 {
    public static void solution(List<Integer> firstList, List<Integer> secondList){
        firstList.addAll(secondList);
        firstList.sort(Comparator.comparing(Integer::intValue));
        for (Integer integer : firstList) {
            System.out.print(integer+" ");
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        List<Integer> firstList = new ArrayList<>();
        for (int i = 0; i < first; i++) {
            firstList.add(sc.nextInt());
        }
        int second = sc.nextInt();
        List<Integer> secondList = new ArrayList<>();
        for (int i = 0; i < second; i++) {
            secondList.add(sc.nextInt());
        }
        solution(firstList, secondList);
    }
}