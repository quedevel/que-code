package programmers.introduction.day4;

import java.util.Arrays;
import java.util.OptionalDouble;

public class ArrayAverage {

    public static void main(String[] args) {
        ArrayAverage arrayAverage = new ArrayAverage();
        System.out.println(arrayAverage.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(arrayAverage.solution(new int[]{89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99}));
    }

    public double solution(int[] numbers) {
        OptionalDouble average = Arrays.stream(numbers).average();
        return average.getAsDouble();
    }
}
