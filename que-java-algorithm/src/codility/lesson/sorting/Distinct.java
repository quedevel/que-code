package codility.lesson.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Distinct {
//    N is an integer within the range [0..100,000];
//    each element of array A is an integer within the range [−1,000,000..1,000,000].
    public int solution(int[] A) {
        return Arrays.stream(A).boxed().collect(Collectors.toSet()).size();
    }

    public static void main(String[] args) {
        Distinct d = new Distinct();
        System.out.println(d.solution(new int[]{}));
    }
}
