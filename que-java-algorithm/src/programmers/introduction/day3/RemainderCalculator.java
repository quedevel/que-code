package programmers.introduction.day3;

public class RemainderCalculator {

    public static void main(String[] args) {
        RemainderCalculator remainderCalculator = new RemainderCalculator();
        System.out.println(remainderCalculator.solution(3,2));
        System.out.println(remainderCalculator.solution(10,5));
    }

    public int solution(int num1, int num2) {
        return num1%num2;
    }
}
