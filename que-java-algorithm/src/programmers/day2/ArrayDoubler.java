package programmers.day2;

import java.util.Arrays;

public class ArrayDoubler {

    public static void main(String[] args) {
        ArrayDoubler arrayDoubler = new ArrayDoubler();
        System.out.println(Arrays.toString(arrayDoubler.solution(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(arrayDoubler.solution(new int[]{1,2,100,-99,1,2,3})));
    }

    public int[] solution(int[] numbers) {
        return Arrays.stream(numbers).map(i -> i*2).toArray();
    }
}
