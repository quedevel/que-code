package section3;

import java.util.Scanner;

/**
 * 03-06
 * 6. 최대 길이 연속부분수열(복합적 문제)
 */
public class Question3_6 {
    public static void solution(int l,int k, int[] arr){
        int result = 0, cnt = 0, lt = 0;
        for (int rt = 0; rt < l; rt++) {
            if (arr[rt] == 0) cnt++;
            while(cnt > k){
                if (arr[lt] == 0) cnt--;
                lt++;
            }
            result = Math.max(result, rt-lt+1);
        }
        System.out.println(result);
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