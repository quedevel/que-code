package section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question2_1 {
    public static void solution(List<Integer> list){
        String result = "";
        int prev = 0;
        for (int num : list) {
            if (num > prev){
                result += num+" ";
            }
            prev = num;
        }
        System.out.print(result);
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