package programmers.introduction.day4;

public class PizzaDivider {
    public static void main(String[] args) {
        PizzaDivider pizzaDivider = new PizzaDivider();
        System.out.println(pizzaDivider.solution(7,10));
        System.out.println(pizzaDivider.solution(4,12));
    }
    public int solution(int slice, int n) {
        int answer = 0;
        for (int i = 1; i <= n/slice+1; i++) {
            if (slice*i >= n){
                answer = i;
                break;
            }
        }
        return answer;
    }

}
