package programmers.level2;

import java.util.Arrays;

public class Carpet {
    public static void main(String[] args) {
        Carpet carpet = new Carpet();
        System.out.println(Arrays.toString(carpet.solution(10,2)));
        System.out.println(Arrays.toString(carpet.solution(8,1)));
        System.out.println(Arrays.toString(carpet.solution(24,24)));
    }
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int[] answer = new int[2];
        for (int i = 1; i*i <= total; i++) {
            if (total%i == 0){
                answer[0] = total/i;
                answer[1] = i;
                if ((answer[0]-2) * (answer[1]-2) == yellow){
                    return answer;
                }
            }
        }
        return answer;
    }
}
