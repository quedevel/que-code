package codility.lesson.countingelements;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
//    that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            set.add(num);
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!set.contains(i)) return i;
        }
        return 1;
    }

    public static void main(String[] args) {
        MissingInteger m = new MissingInteger();
        System.out.println(m.solution(new int[]{-1, -3}));
    }
}
