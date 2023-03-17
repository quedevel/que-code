package programmers.level1;

import java.util.Arrays;

public class SmallestNumberRemover {
    public static void main(String[] args) {
        SmallestNumberRemover smallestNumberRemover = new SmallestNumberRemover();
        System.out.println(Arrays.toString(smallestNumberRemover.solution(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(smallestNumberRemover.solution(new int[]{10})));
    }
    public int[] solution(int[] arr) {
        if (arr.length == 1){
            return new int[]{-1};
        }

        int min = Arrays.stream(arr).min().getAsInt();

        return Arrays.stream(arr).filter(n -> n != min).toArray();
    }
}
