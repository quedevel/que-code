package programmers.level1;


import java.util.Arrays;

public class FruitVendor {
    public static void main(String[] args) {
        FruitVendor fruitVendor = new FruitVendor();
        System.out.println(fruitVendor.solution(3,4, new int[]{1, 2, 3, 1, 2, 3, 1}));
        System.out.println(fruitVendor.solution(4,3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
    }
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int lastIndex = score.length-1;
        int answer = 0;
        for (int i = 0; i < score.length/m; i++) {
            int min = score[lastIndex];
            for (int j = 0; j < m; j++) {
                min = score[lastIndex];
                lastIndex--;
            }
            answer += min*m;
        }
        return answer;
    }
}
