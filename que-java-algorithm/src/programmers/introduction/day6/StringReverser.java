package programmers.introduction.day6;

public class StringReverser {
    public static void main(String[] args) {
        StringReverser stringReverser = new StringReverser();
        System.out.println(stringReverser.solution("jaron"));
        System.out.println(stringReverser.solution("bread"));
    }
    public String solution(String my_string) {
        return new StringBuffer(my_string).reverse().toString();
    }

}
