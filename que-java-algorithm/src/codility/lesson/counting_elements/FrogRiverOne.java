package codility.lesson.counting_elements;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
//    N and X are integers within the range [1..100,000];
//    each element of array A is an integer within the range [1..X].
    public int solution(int X, int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= X) {
                set.add(A[i]);
            }
            if (set.size() == X){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FrogRiverOne f = new FrogRiverOne();
        System.out.println(f.solution(5,new int[] {1,3,1,4,2,3,5,4}));
    }
}
