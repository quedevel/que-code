package section2;

import java.util.Scanner;

public class Question16 {
    public static void solution(int cnt){
        String result = "";
        int prev = 1;
        int current = 1;
        int sum = 0;
        for (int i = 0; i < cnt; i++) {
            result += prev + " ";
            sum = prev + current;
            prev = current;
            current = sum;
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        solution(cnt);
    }
}