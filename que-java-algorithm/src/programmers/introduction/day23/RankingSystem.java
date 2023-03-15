package programmers.introduction.day23;

import java.util.Arrays;

public class RankingSystem {
    public static void main(String[] args) {
        RankingSystem rankingSystem = new RankingSystem();
        System.out.println(Arrays.toString(rankingSystem.solution(new int[][]{{80,70},{90,50},{40,70},{50,80}})));
        System.out.println(Arrays.toString(rankingSystem.solution(new int[][]{{85,70},{70,80},{41,70},{90,100},{100,90},{100,100},{10,30}})));
    }
    public int[] solution(int[][] score) {
        float[] average = new float[score.length];
        for (int i = 0; i < score.length; i++) {
            average[i] = (score[i][0]+score[i][1])/2f;
        }

        int[] answer = new int[average.length];

        for (int i = 0; i < average.length; i++) {
            int rank = 1;
            for (int j = 0; j < average.length; j++) {
                if (average[i] < average[j]) rank++;
            }
            answer[i] = rank;
        }
        return answer;
    }
}
