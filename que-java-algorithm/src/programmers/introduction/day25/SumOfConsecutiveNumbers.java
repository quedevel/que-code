package programmers.introduction.day25;

import java.util.Arrays;

public class SumOfConsecutiveNumbers {
    public static void main(String[] args) {
        SumOfConsecutiveNumbers sumOfConsecutiveNumbers = new SumOfConsecutiveNumbers();
        System.out.println(Arrays.toString(sumOfConsecutiveNumbers.solution(3,12)));
        System.out.println(Arrays.toString(sumOfConsecutiveNumbers.solution(5,15)));
        System.out.println(Arrays.toString(sumOfConsecutiveNumbers.solution(4,14)));
        System.out.println(Arrays.toString(sumOfConsecutiveNumbers.solution(5,5)));
    }
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        for (int i = num > total? total-num : -1; i <= total; i++) {
            if (i+num-1 <= 1000){
                int sum = 0;
                for (int j = 0; j <num; j++) {
                    answer[j] = i + j;
                    sum += i+j;
                }
                if (sum == total){
                    return answer;
                }
            }
        }
        return answer;
    }
}
