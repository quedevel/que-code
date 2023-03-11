package programmers.introduction.day16;

import java.util.Arrays;

public class MaxFinder {
    public static void main(String[] args) {
        MaxFinder maxFinder = new MaxFinder();
        System.out.println(Arrays.toString(maxFinder.solution(new int[]{1,8,3})));
        System.out.println(Arrays.toString(maxFinder.solution(new int[]{9,10,11,8})));
    }
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int max = Arrays.stream(array).max().getAsInt();
        answer[0] = max;
        for (int i = 0; i < array.length; i++) {
            if (max == array[i]){
                answer[1] = i;
                break;
            }
        }
        return answer;
    }
}
