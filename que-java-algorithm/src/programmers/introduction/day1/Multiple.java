package programmers.introduction.day1;

public class Multiple {

    public static void main(String[] args) {
        Multiple multiple = new Multiple();
        System.out.println(multiple.solution(3,4));
        System.out.println(multiple.solution(27,19));
        System.out.println(multiple.solution(100,100));
        System.out.println(multiple.solution(0,0));
        System.out.println(multiple.solution(100,0));
    }

    public int solution(int num1, int num2) {
        int answer = 0;
        if (validation(num1) && validation(num2)){
            answer = num1 * num2;
        }
        return answer;
    }

    private static boolean validation(int n) {
        return n >= 0 && n <= 100;
    }
}
