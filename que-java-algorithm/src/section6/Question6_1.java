package section6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 06-01
 * 1. 선택 정렬
 */
public class Question6_1 {
    public static int[] solution(int[] arr){
        int[] result = Arrays.stream(arr).sorted().toArray();
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i : solution(arr)) {
            System.out.print(i + " ");
        }
    }
}