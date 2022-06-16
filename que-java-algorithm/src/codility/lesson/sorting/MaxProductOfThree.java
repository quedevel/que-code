package codility.lesson.sorting;

import java.util.Arrays;

public class MaxProductOfThree {

    //N is an integer within the range [3..100,000];
    //each element of array A is an integer within the range [−1,000..1,000].
    public int solution(int[] A) {
        Arrays.sort(A);
        int R = A.length-1;
        int Q = R-1;
        int P = Q-1;
        int max = A[R]*A[Q]*A[P];
        if (A[0] <= 0 && A[1] <= 0 & A[R] >= 0){
            int temp = A[0]*A[1]*A[R];
            if (temp > max) max = temp;
        }
        return max;
    }


    public static void main(String[] args) {
        MaxProductOfThree m = new MaxProductOfThree();
        System.out.println(m.solution(new int[]{-3, 1, 2, -2, 5, 6}));
    }
}
