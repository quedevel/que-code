package programmers.introduction.day12;

import java.util.Arrays;
import java.util.List;

public class VowelRemover {

    public static void main(String[] args) {
        VowelRemover vowelRemover = new VowelRemover();
        System.out.println(vowelRemover.solution("bus"));
        System.out.println(vowelRemover.solution("nice to meet you"));
    }
    public String solution(String my_string) {
        String answer = "";
        List<String> strings = Arrays.asList("a", "e", "i", "o", "u");
        for (String s : my_string.split("")) {
            if (!strings.contains(s)) answer += s;
        }
        return answer;
    }
}
