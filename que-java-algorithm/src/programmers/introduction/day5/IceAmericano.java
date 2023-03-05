package programmers.introduction.day5;

import java.util.Arrays;

public class IceAmericano {
    public static void main(String[] args) {
        IceAmericano iceAmericano = new IceAmericano();
        System.out.println(Arrays.toString(iceAmericano.solution(5500)));
        System.out.println(Arrays.toString(iceAmericano.solution(15000)));
    }
    public int[] solution(int money) {
        return new int[]{money/5500, money%5500};
    }
}
