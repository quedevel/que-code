package programmers.introduction.day8;

import java.util.Arrays;

public class ArraySlice {
    public static void main(String[] args) {
        ArraySlice arraySlice = new ArraySlice();
        System.out.println(Arrays.toString(arraySlice.solution(new int[]{1, 2, 3, 4, 5},1,3)));
        System.out.println(Arrays.toString(arraySlice.solution(new int[]{1, 3, 5},1,2)));
    }
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = new int[num2-num1+1];
        int j = 0;
        for (int i = num1; i <= num2; i++) {
            answer[j] = numbers[i];
            j++;
        }
        return answer;
    }
}
