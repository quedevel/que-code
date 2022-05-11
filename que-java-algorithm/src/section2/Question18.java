package section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question18 {
    public static void solution(List<Integer> list){
        list.forEach(num -> {
            StringBuffer sb = new StringBuffer(String.valueOf(num));
            int reversedNum = Integer.valueOf(sb.reverse().toString());
            boolean isPrime = true;
            for (int i = 2; i < reversedNum; i++) {
                if (reversedNum%i == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime && reversedNum != 1){
                System.out.print(reversedNum+" ");
            }
        });
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