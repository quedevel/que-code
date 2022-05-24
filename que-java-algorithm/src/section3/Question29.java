package section3;

import java.util.Scanner;

/**
 * 03-05
 * 5. 연속된 자연수의 합
 */
public class Question29 {
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