package section2;

import java.util.Scanner;

public class Question2_5 {
    public static void solution(int cnt){
        int result = 0;
        int[] iArr = new int[cnt+1];
        for (int i = 2; i <= cnt; i++) {
            if (iArr[i] == 0){
                result++;
                for (int j = i; j <= cnt; j=j+i) {
                    iArr[j] = 1;
                }
            }
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        solution(cnt);
    }
}