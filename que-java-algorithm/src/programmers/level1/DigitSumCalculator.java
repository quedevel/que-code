package programmers.level1;

public class DigitSumCalculator {
    public static void main(String[] args) {
        DigitSumCalculator digitSumCalculator = new DigitSumCalculator();
        System.out.println(digitSumCalculator.solution(123));
        System.out.println(digitSumCalculator.solution(987));
    }
    public int solution(int n) {
        int answer = 0;
        int length = (n+"").length();
        for (int i = (int) Math.pow(10, length-1); i >= 1; i /= 10) {
            answer += n/i;
            n = n%i;
        }
        return answer;
    }
}
