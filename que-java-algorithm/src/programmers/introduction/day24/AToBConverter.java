package programmers.introduction.day24;

import java.util.Arrays;

public class AToBConverter {
    public static void main(String[] args) {
        AToBConverter aToBConverter = new AToBConverter();
        System.out.println(aToBConverter.solution("olleh","hello"));
        System.out.println(aToBConverter.solution("allpe","apple"));
    }
    public int solution(String before, String after) {
        return convert(before).equals(convert(after))? 1: 0;
    }

    public static String convert(String s) {
        String[] split = s.split("");
        Arrays.sort(split);
        return Arrays.stream(split).reduce("",(a,b)->a+b);
    }

}
