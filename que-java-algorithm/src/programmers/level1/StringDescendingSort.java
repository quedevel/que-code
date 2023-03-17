package programmers.level1;

import java.util.Arrays;
import java.util.Collections;

public class StringDescendingSort {
    public static void main(String[] args) {
        StringDescendingSort stringDescendingSort = new StringDescendingSort();
        System.out.println(stringDescendingSort.solution("Zbcdefg"));
    }
    public String solution(String s) {
        String[] split = s.split("");
        Arrays.sort(split, Collections.reverseOrder());
        return String.join("",split);
    }
}
