package programmers.introduction.day4;

public class PizzaSharing {
    public static void main(String[] args) {
        PizzaSharing pizzaSharing = new PizzaSharing();
        System.out.println(pizzaSharing.solution(7));
        System.out.println(pizzaSharing.solution(1));
        System.out.println(pizzaSharing.solution(15));
    }
    public int solution(int n) {
        return n%7 >0? n/7+1 : n/7;
    }

}
