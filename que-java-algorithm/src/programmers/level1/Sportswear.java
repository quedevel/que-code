package programmers.level1;

import java.util.Arrays;

public class Sportswear {
    public static void main(String[] args) {
        Sportswear sportswear = new Sportswear();
        System.out.println(sportswear.solution(5, new int[]{2,4}, new int[]{1,3,5}));
        System.out.println(sportswear.solution(5, new int[]{2,4}, new int[]{3}));
        System.out.println(sportswear.solution(3, new int[]{3}, new int[]{1}));
//        System.out.println(sportswear.solution(30, new int[]{2}, new int[]{1,3}));
    }
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int answer = n - lost.length;
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i]-1 == reserve[j] || lost[i]+1 == reserve[j]){
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}

