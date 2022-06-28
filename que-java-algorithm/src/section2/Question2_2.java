package section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question2_2 {
    public static void solution(List<Integer> list){
        int cnt = 0;
        int prev = 0;
        for (int num : list) {
            if (num > prev){
                cnt++;
                prev = num;
            }
        }
        System.out.print(cnt);
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