package codility.lesson.counting_elements;

import java.util.Arrays;

public class MaxCounters {
//  if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
//  if A[K] = N + 1 then operation K is max counter.
    public int[] solution(int N, int[] A) {
        int[] counter = new int[N];
        int nextMax = 0;
        int prevMax = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1){
                prevMax = nextMax;
            } else {
                int idx = A[i] - 1;
                if (counter[idx] < prevMax){
                    counter[idx] = prevMax + 1;
                } else {
                    counter[idx]++;
                }
                if (counter[idx] > nextMax) nextMax = counter[idx];
            }
        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] < prevMax){
                counter[i] = prevMax;
            }
        }
        System.out.println("counter = " + Arrays.toString(counter));
        return counter;
    }

    public static void main(String[] args) {
        MaxCounters m = new MaxCounters();
        System.out.println(m.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}));
    }
}
