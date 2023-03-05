package programmers.introduction.day6;

import java.util.Arrays;

public class ParityCounter {
    public static void main(String[] args) {
        ParityCounter parityCounter = new ParityCounter();
        System.out.println(Arrays.toString(parityCounter.solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(parityCounter.solution(new int[]{1, 3, 5, 7})));
    }
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        for (int i : num_list) {
            if(i%2 == 0){
                answer[0]++;
            } else {
                answer[1]++;
            }
        }
        return answer;
    }
}
