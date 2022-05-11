package section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question15 {
    public static void solution(List<Integer> list, int cnt){
        String result = "";

        List<Integer> listA = list.subList(0,cnt);
        List<Integer> listB = list.subList(cnt,list.size());

        // 1:가위, 2:바위, 3:보
        for (int i = 0; i < cnt; i++) {
            if(listA.get(i) == listB.get(i)){
                result = "D";
            } else if (listA.get(i) == 1){
                if (listB.get(i) == 2) result = "B";
                else result = "A";
            } else if (listA.get(i) == 2) {
                if (listB.get(i) == 3) result = "B";
                else result = "A";
            } else {
                if (listB.get(i) == 1) result = "B";
                else result = "A";
            }
            System.out.println(result);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < cnt*2; i++) {
            list.add(sc.nextInt());
        }
        solution(list, cnt);
    }
}