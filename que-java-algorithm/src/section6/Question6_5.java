package section6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 06-05
 * 5. 중복 확인
 */
public class Question6_5 {
    public static String solution(int[] arr){
        String result = "U";
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            if (map.containsKey(n)){
                result = "D";
                break;
            } else {
                map.put(n,1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(arr));
    }
}