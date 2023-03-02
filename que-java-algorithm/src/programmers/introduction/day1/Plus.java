package programmers.introduction.day1;

public class Plus {

    public static void main(String[] args) {
        Plus plus = new Plus();
        System.out.println(plus.solution(2,3));
        System.out.println(plus.solution(100,2));
        System.out.println(plus.solution(-50000,50000));
        System.out.println(plus.solution(-50000,-50000));
    }

    public int solution(int num1, int num2) {
        int answer = -1;
        if (validation(num1) && validation(num2)){
            answer = num1 + num2;
        }
        return answer;
    }

    private static boolean validation(int n) {
        return n >= -50000 && n <= 50000;
    }
}
