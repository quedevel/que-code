package programmers.level2;

import java.util.Arrays;

public class SquareArrayDivider {
    public static void main(String[] args) {
        SquareArrayDivider squareArrayDivider = new SquareArrayDivider();
        System.out.println(Arrays.toString(squareArrayDivider.solution(3,2,5)));
        System.out.println(Arrays.toString(squareArrayDivider.solution(4,7,14)));
    }

    //  1  2  3
    //  2  2  3
    //  3  3  3

    //  1  2  3  4
    //  2  2  3  4
    //  3  3  3  4
    //  4  4  4  4

    // 1: 1, 2: 3, 3: 5

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right-left+1)];
        for (int i = 0; i < answer.length; i++) {
            int line = (int) ((left / n) + 1);
            int remain = (int) (left % n);
            answer[i] = line + (remain == line ? 1 : remain < line ? 0 : remain - line + 1);
            left++;
        }
        return answer;
    }
}
