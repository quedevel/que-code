package section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question2_7 {
    public static void solution(List<Integer> list){
        int point = 0;
        int sum = 0;
        for (int num : list) {
            if (num == 1){
                point++;
            } else {
                point = 0;
            }
            sum += point;
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            list.add(sc.nextInt());
        }
        solution(list);
    }
}