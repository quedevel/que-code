package programmers.introduction.day13;

import java.util.Arrays;

public class ArrayElementLength {
    public static void main(String[] args) {
        ArrayElementLength arrayElementLength = new ArrayElementLength();
        System.out.println(Arrays.toString(arrayElementLength.solution(new String[]{"We", "are", "the", "world!"})));
        System.out.println(Arrays.toString(arrayElementLength.solution(new String[]{"I", "Love", "Programmers."})));
    }
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        for (int i = 0; i < strlist.length; i++) {
            answer[i] = strlist[i].length();
        }
        return answer;
    }
}
