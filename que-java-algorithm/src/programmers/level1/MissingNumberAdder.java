package programmers.level1;

import java.util.Arrays;

public class MissingNumberAdder {
    public static void main(String[] args) {
        MissingNumberAdder missingNumberAdder = new MissingNumberAdder();
        System.out.println(missingNumberAdder.solution(new int[]{1,2,3,4,6,7,8,0}));
        System.out.println(missingNumberAdder.solution(new int[]{5,8,4,0,6,7,9}));
    }
    public int solution(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }
}
