package section6;

import java.util.Scanner;

/**
 * 06-034
 * 4. LRU(Least Recently Used)
 */
public class Question6_4 {
    public static int[] solution(int size, int n, int[] arr){
        int[] cache = new int[size];
        for (int x : arr) {
            int idx  = -1;
            for (int i = 0; i < size; i++) {
                if (x == cache[i]) idx = i;
            }
            if (idx == -1){
                swap(cache, x, size - 1);
            } else {
                swap(cache, x, idx);
            }
        }
        return cache;
    }

    private static void swap(int[] cache, int x, int idx) {
        for (int i = idx; i >= 1; i--) {
            cache[i] = cache[i-1];
        }
        cache[0] = x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i : solution(size, n, arr)) {
            System.out.print(i + " ");
        }
    }
}