package programmers.introduction.day19;

import java.util.Arrays;

public class TallerThanAnyone {
    public static void main(String[] args) {
        TallerThanAnyone tallerThanAnyone = new TallerThanAnyone();
        System.out.println(tallerThanAnyone.solution(new int[]{149, 180, 192, 170}, 167));
        System.out.println(tallerThanAnyone.solution(new int[]{180, 120, 140}, 190));
    }
    public int solution(int[] array, int height) {
        return (int)Arrays.stream(array).filter(h -> h > height).count();
    }
}
