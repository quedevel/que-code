package programmers.introduction.etc;

import java.util.HashSet;
import java.util.Set;

public class TriangleCompletenessChecker {
    public static void main(String[] args) {
        TriangleCompletenessChecker triangleCompletenessChecker = new TriangleCompletenessChecker();
        System.out.println(triangleCompletenessChecker.solution(new int[]{1,2}));
        System.out.println(triangleCompletenessChecker.solution(new int[]{3,6}));
        System.out.println(triangleCompletenessChecker.solution(new int[]{11,7}));
    }
    public int solution(int[] sides) {
        Set<Integer> set = new HashSet<>();

        int sidesMax = sides[0] > sides[1]? sides[0] : sides[1];
        int sidesMin = sides[0] > sides[1]? sides[1] : sides[0];

        for (int i = sidesMax-sidesMin+1; i <= sidesMax; i++) {
            set.add(i);
        }

        for (int i = sidesMax+1; i < sidesMax+sidesMin; i++) {
            set.add(i);
        }


        return set.size();
    }
}
