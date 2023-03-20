package programmers.level1;

import java.util.Arrays;

public class LottoRank {
    public static void main(String[] args) {
        LottoRank lottoRank = new LottoRank();
//        System.out.println(Arrays.toString(lottoRank.solution(new int[]{44, 1, 0, 0, 31, 2},new int[]{31, 10, 45, 1, 6, 19})));
//        System.out.println(Arrays.toString(lottoRank.solution(new int[]{0, 0, 0, 0, 0, 0},new int[]{38, 19, 20, 40, 15, 25})));
//        System.out.println(Arrays.toString(lottoRank.solution(new int[]{45, 4, 35, 20, 3, 9},new int[]{20, 9, 3, 45, 4, 35})));
        System.out.println(Arrays.toString(lottoRank.solution(new int[]{1, 2, 3, 4, 5, 6},new int[]{7, 8, 9, 10, 11, 12})));
    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int invisible = (int) Arrays.stream(lottos).filter(n -> n == 0).count();
        int win = 0;
        for (int lotto : lottos) {
            for (int w : win_nums) {
                if (lotto == w) win++;
            }
        }
        answer[0] = Math.abs(win + invisible - 7 == -7? 6: win + invisible -7);
        answer[1] = Math.abs(win - 7 == -7? 6: win-7);
        return answer;
    }
}
