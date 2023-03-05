package programmers.introduction.day7;

public class StringRemover {
    public static void main(String[] args) {
        StringRemover stringRemover = new StringRemover();
        System.out.println(stringRemover.solution("abcdef","f"));
        System.out.println(stringRemover.solution("BCBdbe","B"));
    }
    public String solution(String my_string, String letter) {
        return my_string.replaceAll(letter,"");
    }
}
