package programmers.level1;

import java.util.*;

public class HonorRoll {
    public static void main(String[] args) {
        HonorRoll honorRoll = new HonorRoll();
        System.out.println(Arrays.toString(honorRoll.solution(3, new int[]{10, 100, 20, 150, 1, 100, 200})));
        System.out.println(Arrays.toString(honorRoll.solution(4, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000})));
    }
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < score.length; i++) {
            deque.offerLast(score[i]);
            if (deque.size() > k) {
                deque.pollFirst();
            }
            if (deque.size() == k) {
                answer[i] = deque.stream().min(Integer::compare).orElse(0);
            }
        }
        return answer;
    }
}
