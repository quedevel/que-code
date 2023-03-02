package programmers.day1;

public class Minus {

    public static void main(String[] args) {
        Minus minus = new Minus();
        System.out.println(minus.solution(2,3));
        System.out.println(minus.solution(100,2));
        System.out.println(minus.solution(-50000,50000));
    }

    public int solution(int num1, int num2) {
        int answer = 0;
        if (validation(num1) && validation(num2)){
            answer = num1 - num2;
        }
        return answer;
    }

    private static boolean validation(int n) {
        return n >= -50000 && n <= 50000;
    }
}
