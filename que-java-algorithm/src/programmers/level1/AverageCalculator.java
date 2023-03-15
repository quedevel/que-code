package programmers.level1;

import java.util.Arrays;

public class AverageCalculator {
    public static void main(String[] args) {
        AverageCalculator averageCalculator = new AverageCalculator();
        System.out.println(averageCalculator.solution(new int[]{1,2,3,4}));
        System.out.println(averageCalculator.solution(new int[]{5,5}));
    }
    public double solution(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }
}
