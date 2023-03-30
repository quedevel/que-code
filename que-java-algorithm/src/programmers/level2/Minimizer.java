package programmers.level2;

import java.util.Arrays;

public class Minimizer {
    public static void main(String[] args) {
        Minimizer minimizer = new Minimizer();
        System.out.println(minimizer.solution(new int[]{1,4,2}, new int[]{5,4,4}));
        System.out.println(minimizer.solution(new int[]{1,2}, new int[]{3,4}));
    }
    public int solution(int []A, int []B) {
        int answer = 0;
        int length = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < length; i++) {
            answer += A[i]*B[length-1-i];
        }
        return answer;
    }
}
