package programmers.introduction.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSorting {
    public static void main(String[] args) {
        StringSorting stringSorting = new StringSorting();
        System.out.println(Arrays.toString(stringSorting.solution("hi12392")));
        System.out.println(Arrays.toString(stringSorting.solution("p2o4i8gj2")));
        System.out.println(Arrays.toString(stringSorting.solution("abcde0")));
    }
    public int[] solution(String my_string) {
        List<Integer> list = new ArrayList<>();
        char[] chars = my_string.toCharArray();
        for (char c : chars) {
            if(c > 47 & c < 58) list.add(Integer.valueOf(c+""));
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
