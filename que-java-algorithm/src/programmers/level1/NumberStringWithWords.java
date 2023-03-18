package programmers.level1;

public class NumberStringWithWords {
    public static void main(String[] args) {
        NumberStringWithWords numberStringWithWords = new NumberStringWithWords();
        System.out.println(numberStringWithWords.solution("one4seveneight"));
        System.out.println(numberStringWithWords.solution("23four5six7"));
        System.out.println(numberStringWithWords.solution("2three45sixseven"));
        System.out.println(numberStringWithWords.solution("123"));
    }
    public int solution(String s) {
        s = convert(s, "zero", "0");
        s = convert(s, "one", "1");
        s = convert(s, "two", "2");
        s = convert(s, "three", "3");
        s = convert(s, "four", "4");
        s = convert(s, "five", "5");
        s = convert(s, "six", "6");
        s = convert(s, "seven", "7");
        s = convert(s, "eight", "8");
        s = convert(s, "nine", "9");
        return Integer.valueOf(s);
    }

    private static String convert(String s, String target, String replacement){
        return s.indexOf(target) >= 0? s.replaceAll(target, replacement): s;
    }

}
