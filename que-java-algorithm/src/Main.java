import java.util.Scanner;

public class Main {
    public static int[] solution(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i-1; j >= 0; j--) {
                if (arr[j] > temp){
                    arr[j+1] = arr[j];
                    if (j == 0) arr[j] = temp;
                } else {
                    arr[j+1] = temp;
                    break;
                }
            }
        }
        return arr;
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
