package section3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 03-04
 * 4. 연속 부분수열
 */
public class Question3_4 {
    public static void solution(int goal, int[] iArr){
        int cnt = 0;
        int result = 0;
        for (int i = 0; i < iArr.length; i++) {
            cnt = 0;
            for (int j = i; j < iArr.length; j++) {
                cnt += iArr[j];
                if (cnt == goal){
                    result++;
                    break;
                } else if (cnt > goal){
                    break;
                }
            }
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int goal = sc.nextInt();
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = sc.nextInt();
        }
        solution(goal, iArr);
    }
}