package codility.lesson.timecomplexity;

import java.util.Arrays;

public class PermMissingElem {

//    N is an integer within the range [0..100,000];
//    the elements of A are all distinct;
//    each element of array A is an integer within the range [1..(N + 1)].
    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i=0; i<A.length; i++) {
            if (A[i] != i+1) {
                return i+1;
            }
        }
        return A.length + 1;
    }

    public static void main(String[] args) {
        PermMissingElem p = new PermMissingElem();
        System.out.println(p.solution(new int[]{1}));
    }
}
