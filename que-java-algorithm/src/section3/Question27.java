package section3;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Question27 {
    public static void solution(int cnt, int[] iArr){
        int max = 0;
        for (int i = 0; i < iArr.length; i++) {
            int sum = 0;
            for (int j = 0; j < cnt; j++) {
                if (i+j < iArr.length){
                    sum += iArr[i+j];
                }
            }
            if (sum > max) max = sum;
        }
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