package programmers.introduction.day19;

import java.util.Arrays;

public class ArrayCutter {
    public static void main(String[] args) {
        ArrayCutter arrayCutter = new ArrayCutter();
        System.out.println(Arrays.toString(arrayCutter.solution("abc1Addfggg4556b",6)));
        System.out.println(Arrays.toString(arrayCutter.solution("abcdef123",3)));
    }
    public String[] solution(String my_str, int n) {
        int length = my_str.length()%n == 0? my_str.length()/n : my_str.length()/n+1;
        String[] answer = new String[length];

        String[] split = my_str.split("");

        for (int i = 0; i < split.length; i++) {
            if (answer[i/n] == null){
                answer[i/n] = split[i];
            } else {
                answer[i/n] += split[i];
            }
        }
        return answer;
    }
}
