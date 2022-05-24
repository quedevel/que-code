package section3;

import java.util.Scanner;

/**
 * 03-04
 * 4. 연속 부분수열
 */
public class Question28 {
    public static void solution(int cnt, int[] iArr){
        int max = 0;

        System.out.println(max);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int cnt = sc.nextInt();
        int[] iArr = new int[total];
        for (int i = 0; i < total; i++) {
            iArr[i] = sc.nextInt();
        }
        solution(cnt, iArr);
    }
}