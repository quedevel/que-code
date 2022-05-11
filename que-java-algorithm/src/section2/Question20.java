package section2;

import java.util.*;
import java.util.stream.Collectors;

public class Question20 {
    public static void solution(List<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            int grade = 1;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i) < list.get(j)){
                    grade++;
                }
            }
            System.out.print(grade+" ");
            grade = 1;
        }

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