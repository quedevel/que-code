package programmers.level1;

import java.util.Arrays;

public class ReverseArrayBuilder {
    public static void main(String[] args) {
        ReverseArrayBuilder reverseArrayBuilder = new ReverseArrayBuilder();
        System.out.println(Arrays.toString(reverseArrayBuilder.solution(12345L)));
    }
    public int[] solution(long n) {
        String str = n+"";
        StringBuffer stringBuffer = new StringBuffer(str);
        StringBuffer reverse = stringBuffer.reverse();
        String s = reverse.toString();
        String[] split = s.split("");
        int length = s.length();
        int[] answer = new int[length];
        for (int i = 0; i < split.length; i++) {
            answer[i] = Integer.valueOf(split[i]);
        }
        return answer;
    }
}
