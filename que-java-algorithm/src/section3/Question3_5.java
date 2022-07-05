package section3;

import java.util.Scanner;

/**
 * 03-05
 * 5. 연속된 자연수의 합
 */
public class Question3_5 {
    public static void solution(int num){
        int result = 0;
        int maxLength = num%2 == 0? num/2 : num/2+1;
        for (int i = 1; i <= maxLength; i++) {
            int sum = 0;
            for (int j = i; j <= maxLength; j++) {
                sum += j;
                if (sum == num){
                    result++;
                    break;
                } else if (sum > num){
                    break;
                }
            }
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        solution(num);
    }
}