package programmers.introduction.day11;

public class Factorial {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.solution(3628800));
        System.out.println(factorial.solution(7));
    }
    public int solution(int n){
        int num = 1;
        int answer = 0;
        for (int i = 1; i < 11; i++) {
            num *= i;
            if(num >= n){
                answer = num == n? i : i-1;
                break;
            }
        }
        return answer;
    }
}
