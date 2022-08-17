package section6;

import java.util.Scanner;

/**
 * 06-08
 * 8. 이분 검색
 */
public class Question6_8 {
    public static int solution(int[] arr, int n){
        selectionSort(arr);
        return binarySearch(arr, n)+1;
    }

    private static int binarySearch(int[] arr, int n) {
        int start = 0;
        int end = arr.length-1;
        int middle;
        while(start <= end) {
            middle = (start + end)/2;
            if (arr[middle] == n){
                return middle;
            } else if (arr[middle] < n){
                start = middle+1;
            } else if (arr[middle] > n){
                end = middle-1;
            }
        }
        return -1;
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(arr, n));
    }
}