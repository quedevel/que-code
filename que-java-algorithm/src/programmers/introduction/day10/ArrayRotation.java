package programmers.introduction.day10;

import java.util.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        ArrayRotation arrayRotation = new ArrayRotation();
        System.out.println(Arrays.toString(arrayRotation.solution(new int[]{1,2,3},"right")));
        System.out.println(Arrays.toString(arrayRotation.solution(new int[]{4,455,6,4,-1,45,6},"left")));
    }
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        if (direction.equals("right")){
            for (int i = 0; i < numbers.length-1; i++) {
                answer[i+1] = numbers[i];
            }
            answer[0] = numbers[numbers.length-1];
        } else if (direction.equals("left")){
            for (int i = 0; i < numbers.length - 1; i++) {
                answer[i] = numbers[i+1];
            }
            answer[numbers.length-1] = numbers[0];
        }
        return answer;
    }
}
