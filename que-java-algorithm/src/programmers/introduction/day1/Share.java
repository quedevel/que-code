package programmers.introduction.day1;

public class Share {

    public static void main(String[] args) {
        System.out.println(solution(10,5));
        System.out.println(solution(7,2));
    }

    public static int solution(int num1, int num2) {
        int answer = 0;
        if(validation(num1) && validation(num2)){
            answer = num1/num2;
        }
        return answer;
    }

    private static boolean validation(int n) {
        return n > 0 && n <= 100;
    }
}
