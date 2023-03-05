package programmers.introduction.day19;

import java.util.Arrays;

public class DuplicateNumberCount {
    public static void main(String[] args) {
        DuplicateNumberCount duplicateNumberCount = new DuplicateNumberCount();
        System.out.println(duplicateNumberCount.solution(new int[]{1, 1, 2, 3, 4, 5},1));
        System.out.println(duplicateNumberCount.solution(new int[]{0, 2, 3, 4},1));
    }
    public int solution(int[] array, int n) {
        return (int) Arrays.stream(array).filter( i -> i == n).count();
    }
}
