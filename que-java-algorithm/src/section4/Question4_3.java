package section4;

import java.util.*;

/**
 * 04-03
 * 3. 매출액의 종류
 */
public class Question4_3 {
    public static void solution(int l, int k, int[] arr){
        List<String> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        int lt = 0;
        for (int rt = k - 1; rt < l; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt],0 )+1);
            answer.add(String.valueOf(map.size()));
            map.put(arr[lt], map.get(arr[lt])-1);
            if (map.get(arr[lt]) == 0){
                map.remove(arr[lt]);
            }
            lt++;
        }
        System.out.println(String.join(" ", answer));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[l];
        for (int i = 0; i < l; i++) {
            arr[i] = sc.nextInt();
        }
        solution(l, k, arr);
    }
}