package programmers.introduction.day3;

import java.util.Arrays;

public class NoEvenNumber {
    public static void main(String[] args) {
        NoEvenNumber noEvenNumber = new NoEvenNumber();
        System.out.println(Arrays.toString(noEvenNumber.solution(10)));
        System.out.println(Arrays.toString(noEvenNumber.solution(15)));
    }
    public int[] solution(int n) {
        int[] answer = new int[(n+1)/2];
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if(i%2 == 1){
                answer[j] = i;
                j++;
            }
        }
        return answer;
    }
}
