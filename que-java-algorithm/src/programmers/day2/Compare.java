package programmers.day2;

public class Compare {

    public static void main(String[] args) {
        Compare compare = new Compare();
        System.out.println(compare.solution(2,3));
        System.out.println(compare.solution(11,11));
        System.out.println(compare.solution(7,99));
    }

    public int solution(int num1, int num2) {
        int answer = 0;
        if (validation(num1) && validation(num2)){
            answer = num1 == num2? 1 : -1;
        }
        return answer;
    }

    private static boolean validation(int n) {
        return n >= 0 && n <= 10000;
    }
}
