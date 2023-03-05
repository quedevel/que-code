package programmers.introduction.day4;

public class PizzaSharing2 {
    public static void main(String[] args) {
        PizzaSharing2 pizzaSharing = new PizzaSharing2();
        System.out.println(pizzaSharing.solution(6));
        System.out.println(pizzaSharing.solution(10));
        System.out.println(pizzaSharing.solution(4));
    }
    public int solution(int n) {
        int answer = 1;
        while(6*answer%n != 0){
            answer++;
        }
        return answer;
    }

}
