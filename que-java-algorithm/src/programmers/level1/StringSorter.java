package programmers.level1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringSorter {
    public static void main(String[] args) {
        StringSorter stringSorter = new StringSorter();
        System.out.println(Arrays.toString(stringSorter.solution(new String[]{"sun","bed","car"},1)));
        System.out.println(Arrays.toString(stringSorter.solution(new String[]{"abce","abcd","cdx"},2)));
    }
    public String[] solution(String[] strings, int n) {
        String[] answer = Arrays.stream(strings).sorted((o1, o2) -> o1.charAt(n) > o2.charAt(n) ? 1 : o1.charAt(n) < o2.charAt(n) ? -1 : o1.compareTo(o2)).collect(Collectors.joining(",")).split(",");
        return answer;
    }
}
