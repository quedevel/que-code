package programmers.level1;

public class EvenOdd {
    public static void main(String[] args) {
        EvenOdd evenOdd = new EvenOdd();
        System.out.println(evenOdd.solution(3));
        System.out.println(evenOdd.solution(4));
    }
    public String solution(int num) {
        return num%2 == 0? "Even" : "Odd";
    }
}
