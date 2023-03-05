package programmers.introduction.day17;

import java.util.Arrays;

public class MultiplesOfN {

    public static void main(String[] args) {
        MultiplesOfN multiplesOfN = new MultiplesOfN();
        System.out.println(Arrays.toString(multiplesOfN.solution(3,new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12})));
        System.out.println(Arrays.toString(multiplesOfN.solution(5,new int[]{1, 9, 3, 10, 13, 5})));
        System.out.println(Arrays.toString(multiplesOfN.solution(12,new int[]{2, 100, 120, 600, 12, 12})));
    }

    public int[] solution(int n, int[] numlist) {
        return Arrays.stream(numlist).filter(i -> i % n == 0).toArray();
    }
}
