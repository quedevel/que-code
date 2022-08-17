package section6;

import java.util.Scanner;

/**
 * 06-07
 * 7. 좌표 정렬
 */
public class Question6_7 {
    public static int[][] solution(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j][0] < arr[i][0]){
                    int[] temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                } else if (arr[j][0] == arr[i][0]) {
                   if (arr[j][1] < arr[i][1]){
                       int[] temp = arr[j];
                       arr[j] = arr[i];
                       arr[i] = temp;
                   }
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        for (int[] intArr : solution(arr)) {
            System.out.println(intArr[0] + " " + intArr[1]);
        }
    }
}