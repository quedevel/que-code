package programmers.introduction.day3;

import java.util.Arrays;

public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        System.out.println(medianFinder.solution(new int[]{1, 2, 7, 10, 11}));
        System.out.println(medianFinder.solution(new int[]{9, -1, 0}));
    }
    public int solution(int[] array) {
        int[] ints = Arrays.stream(array).sorted().toArray();
        return ints[array.length/2];
    }
}
