package programmers.level1;

public class DivisorSumCalculator {
    public static void main(String[] args) {
        DivisorSumCalculator divisorSumCalculator = new DivisorSumCalculator();
        System.out.println(divisorSumCalculator.solution(13,17));
        System.out.println(divisorSumCalculator.solution(24,27));
    }
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int cnt = 0;
            for (int j = 1; j <= i; j++) {
                if (i%j == 0) cnt++;
            }
            if (cnt%2 == 0){
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }
}
