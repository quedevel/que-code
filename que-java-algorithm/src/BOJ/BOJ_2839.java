package BOJ;

import java.util.Scanner;

public class BOJ_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int length = N / 5;
        int result = -1;
        for (int i = length; i >= 0; i--) {
            if (i != 0 && (N - (i*5)) % 3 == 0){
                result = i + (N - (i*5))/3;
                break;
            } else if (i == 0 && N%3 == 0){
                result = N/3;
                break;
            }
        }
        System.out.println(result);
    }
}
