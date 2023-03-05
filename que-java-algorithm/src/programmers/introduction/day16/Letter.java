package programmers.introduction.day16;

public class Letter {
    public static void main(String[] args) {
        Letter letter = new Letter();
        System.out.println(letter.solution("happy birthday!"));
        System.out.println(letter.solution("I love you~"));
    }
    public int solution(String message) {
        return message.length()*2;
    }
}
