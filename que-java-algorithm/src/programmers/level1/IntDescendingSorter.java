package programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class IntDescendingSorter {
    public static void main(String[] args) {
        IntDescendingSorter intDescendingSorter = new IntDescendingSorter();
        System.out.println(intDescendingSorter.solution(118372));
    }
    public long solution(long n) {
        String str = n+"";
        String[] split = str.split("");
        Arrays.sort(split, Comparator.reverseOrder());
        return Long.valueOf(String.join("",split));
    }
}
