package section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question23 {
    public static void solution(List<List<Integer>> list){
        int cnt = 0;

        List<List<Integer>> reversedList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            reversedList.add(new ArrayList<>());
            for (int j = 0; j < 5; j++) {
                reversedList.get(i).add(list.get(j).get(i));
            }
        }

        List<List<Boolean>> booleans = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            booleans.add(new ArrayList<>());
            for (int j = 0; j < list.size(); j++) {
                boolean flag = false;
                int currentIndex = j;
                int lastIndex = reversedList.get(i).lastIndexOf(reversedList.get(i).get(j));
                if (j != lastIndex){
                    flag = true;
                }
                booleans.get(i).add(flag);
            }
        }

        for (List<Boolean> aBoolean : booleans) {
            for (Boolean aBoolean1 : aBoolean) {
                System.out.print(aBoolean1+" ");
            }
            System.out.println();
        }

        System.out.println(cnt);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            list.add(new ArrayList<>());
            for (int j = 0; j < 5; j++) {
                list.get(i).add(sc.nextInt());
            }
        }
        solution(list);
    }
}