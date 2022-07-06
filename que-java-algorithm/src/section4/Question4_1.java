package section4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 04-01
 * 1. 학급 회장(해쉬)
 */
public class Question4_1 {
    public static void solution(String votedStr){
        int max = 0;
        String elected = "";
        Map<String, Integer> resultMap = new HashMap<>();
        String[] arr = votedStr.split("");
        for (String s : arr) {
            if (resultMap.containsKey(s)){
                int temp = resultMap.get(s);
                resultMap.put(s, temp+1);
            } else {
                resultMap.put(s,1);
            }
        }
        for (String s : resultMap.keySet()) {
            if (resultMap.get(s) > max){
                max = resultMap.get(s);
                elected = s;
            }
        }
        System.out.println(elected);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        String votedStr = sc.next();
        solution(votedStr);
    }
}