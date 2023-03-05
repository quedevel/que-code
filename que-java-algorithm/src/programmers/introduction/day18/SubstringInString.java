package programmers.introduction.day18;

public class SubstringInString {
    public static void main(String[] args) {
        SubstringInString substringInString = new SubstringInString();
        System.out.println(substringInString.solution("ab6CDE443fgh22iJKlmn1o","6CD"));
        System.out.println(substringInString.solution("ppprrrogrammers","pppp"));
        System.out.println(substringInString.solution("AbcAbcA","AAA"));
    }
    public int solution(String str1, String str2) {
        return str1.indexOf(str2) >=0? 1 : 2;
    }
}
