package programmers.introduction.day2;

public class Division {

    public static void main(String[] args) {
        Division division = new Division();
        System.out.println(division.solution(3,2));
        System.out.println(division.solution(7,3));
        System.out.println(division.solution(1,16));
    }

    public int solution(int num1, int num2) {
        int answer = 0;
        if (validation(num1) && validation(num2)){
            float share = (float)num1/num2*1000;
            answer = (int)share;
        }
        return answer;
    }
    private static boolean validation(int n) {
        return n > 0 && n <= 100;
    }
}
