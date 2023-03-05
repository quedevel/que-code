package programmers.introduction.day5;

import java.util.Arrays;

public class ArrayReverser {
    public static void main(String[] args) {
        ArrayReverser arrayReverser = new ArrayReverser();
        System.out.println(Arrays.toString(arrayReverser.solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(arrayReverser.solution(new int[]{1, 1, 1, 1, 1, 2})));
        System.out.println(Arrays.toString(arrayReverser.solution(new int[]{1, 0, 1, 1, 1, 3, 5})));

    }
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        int j = 0;
        for (int i = num_list.length-1; i >= 0; i--) {
            answer[j] = num_list[i];
            j++;
        }
        return answer;
    }

}
