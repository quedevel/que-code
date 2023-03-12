package programmers.introduction.day18;

import java.util.Arrays;

public class StringSorter {
    public static void main(String[] args) {
        StringSorter stringSorter = new StringSorter();
        System.out.println(stringSorter.solution("Bcad"));
        System.out.println(stringSorter.solution("heLLo"));
        System.out.println(stringSorter.solution("Python"));
    }
    public String solution(String my_string) {
        String s = my_string.toLowerCase();
        String[] split = s.split("");
        String answer = Arrays.stream(split).sorted().reduce("", (a, b) -> a + b);
        return answer;
    }
}
