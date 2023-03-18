package programmers.level1;

public class InsufficientAmountCalculator {
    public static void main(String[] args) {
        InsufficientAmountCalculator insufficientAmountCalculator = new InsufficientAmountCalculator();
        System.out.println(insufficientAmountCalculator.solution(3,20,4));
    }
    public long solution(long price, long money, long count) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += i;
        }
        long answer = (price*sum)-money;
        return answer >= 0 ? answer : 0;
    }
}
