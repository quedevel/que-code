package programmers.level1;

import java.util.Arrays;

public class PositiveNegativeAdder {
    public static void main(String[] args) {
        PositiveNegativeAdder positiveNegativeAdder = new PositiveNegativeAdder();
        System.out.println(positiveNegativeAdder.solution(new int[]{4,7,12}, new boolean[]{true,false,true}));
        System.out.println(positiveNegativeAdder.solution(new int[]{1,2,3}, new boolean[]{false,false,true}));
    }
    public int solution(int[] absolutes, boolean[] signs) {
        for (int i = 0; i < signs.length; i++) {
            if (!signs[i]){
                absolutes[i] *= -1;
            }
        }
        return Arrays.stream(absolutes).sum();
    }
}
