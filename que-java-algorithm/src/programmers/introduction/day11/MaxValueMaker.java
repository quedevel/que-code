package programmers.introduction.day11;

import java.util.Arrays;

public class MaxValueMaker {
    public static void main(String[] args) {
        MaxValueMaker maxValueMaker = new MaxValueMaker();
        System.out.println(maxValueMaker.solution(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxValueMaker.solution(new int[]{0, 31, 24, 10, 1, 9}));
    }
    public int solution(int[] numbers) {
        int[] sorted = Arrays.stream(numbers).sorted().toArray();
        return (sorted[numbers.length-1] != 0 && sorted[numbers.length-2] != 0)?
                sorted[numbers.length-1]*sorted[numbers.length-2] : 0;
    }

}
