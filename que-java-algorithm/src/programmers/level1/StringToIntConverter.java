package programmers.level1;

public class StringToIntConverter {
    public static void main(String[] args) {
        StringToIntConverter stringToIntConverter = new StringToIntConverter();
        System.out.println(stringToIntConverter.solution("1234"));
        System.out.println(stringToIntConverter.solution("-1234"));
    }
    public int solution(String s) {
        return Integer.valueOf(s);
    }
}
