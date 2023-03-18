package programmers.level1;

import java.util.Arrays;

public class Budget {
    public static void main(String[] args) {
        Budget budget = new Budget();
        System.out.println(budget.solution(new int[]{1,3,2,5,4},9));
        System.out.println(budget.solution(new int[]{2,2,3,3},10));
    }

    public int solution(int[] d, int budget) {
        int cnt = 0;
        int sum = 0;
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
            if (budget >= sum){
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }
}
