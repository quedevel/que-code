package programmers.introduction.day13;

import java.util.Arrays;

public class TriangleCondition {
    public static void main(String[] args) {
        TriangleCondition triangleCondition = new TriangleCondition();
        System.out.println(triangleCondition.solution(new int[]{1,2,3}));
        System.out.println(triangleCondition.solution(new int[]{3,6,2}));
        System.out.println(triangleCondition.solution(new int[]{199,72,222}));
    }
    public int solution(int[] sides) {
        int[] sorted = Arrays.stream(sides).sorted().toArray();
        return sorted[0]+sorted[1] > sorted[2]? 1 : 2;
    }

}
