package codility.lesson.counting_elements;

import java.util.Arrays;

public class PermCheck {
//  A permutation is a sequence containing each element from 1 to N once
//  N is an integer within the range [1..100,000];
//  each element of array A is an integer within the range [1..1,000,000,000].
    public int solution(int[] A) {
        boolean isPermutation = true;
        Arrays.sort(A);
        if (A[0] != 1){
            return 0;
        } else if (A.length == 1 && A[0] == 1){
            return 1;
        }
        for (int i = 0; i < A.length; i++) {
            if (i+1 < A.length && A[i]+1 != A[i+1]){
                isPermutation = false;
                break;
            }
        }
        return isPermutation? 1: 0;
    }

    public static void main(String[] args) {
        PermCheck p = new PermCheck();
        System.out.println(p.solution(new int[]{2}));
    }
}
