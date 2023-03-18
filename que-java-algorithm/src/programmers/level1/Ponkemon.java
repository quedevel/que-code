package programmers.level1;

import java.util.Arrays;

public class Ponkemon {
    public static void main(String[] args) {
        Ponkemon ponkemon = new Ponkemon();
        System.out.println(ponkemon.solution(new int[]{3,1,2,3}));
        System.out.println(ponkemon.solution(new int[]{3,3,3,2,2,4}));
        System.out.println(ponkemon.solution(new int[]{3,3,3,2,2,2}));
    }
    public int solution(int[] nums) {
        int max = nums.length/2;
        int count = (int) Arrays.stream(nums).distinct().count();
        return max > count? count : max;
    }
}
