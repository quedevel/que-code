package programmers.introduction.day7;

import java.util.Map;

public class EvenNumberSumCalculator {

    public static void main(String[] args) {
        EvenNumberSumCalculator evenNumberSumCalculator = new EvenNumberSumCalculator();
        System.out.println(evenNumberSumCalculator.solution(10));
        System.out.println(evenNumberSumCalculator.solution(4));
        String buy = "bitcoin";
        System.out.println(buy.substring(0,1)+buy.substring(2,4));
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n / 2; i++) {
            if(2*i <= n) answer += 2*i;
        }

        return answer;
    }
}
