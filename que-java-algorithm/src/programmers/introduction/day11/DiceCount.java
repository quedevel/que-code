package programmers.introduction.day11;

import java.util.Arrays;

public class DiceCount {
    public static void main(String[] args) {
        DiceCount diceCount = new DiceCount();
        System.out.println(diceCount.solution(new int[]{1,1,1},1));
        System.out.println(diceCount.solution(new int[]{10,8,6},3));
    }
    public int solution(int[] box, int n) {
        return Arrays.stream(box).map(i -> i / n).reduce(1, (a, b) -> a * b);
    }
}
