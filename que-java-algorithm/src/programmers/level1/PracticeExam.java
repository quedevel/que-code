package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeExam {
    public static void main(String[] args) {
        PracticeExam practiceExam = new PracticeExam();
        System.out.println(Arrays.toString(practiceExam.solution(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(practiceExam.solution(new int[]{1,3,2,4,2})));
    }
    public int[] solution(int[] answers) {
        String[] str1 = getAnswer("12345", answers);
        String[] str2 = getAnswer("21232425",answers);
        String[] str3 = getAnswer("3311224455",answers);

        int[] arr = new int[3];
        int max = 0;
        for (int i = 0; i < answers.length; i++) {
            String value = String.valueOf(answers[i]);
            if (value.equals(str1[i])){
                arr[0]++;
                max = arr[0] > max? arr[0] : max;
            }
            if (value.equals(str2[i])){
                arr[1]++;
                max = arr[1] > max? arr[1] : max;
            }
            if (value.equals(str3[i])){
                arr[2]++;
                max = arr[2] > max? arr[2] : max;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) list.add(i+1);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    private static String[] getAnswer(String pattern, int[] answers){
        String result = "";
        int answerLength = answers.length;
        int patternLength = pattern.length();
        if (answerLength > patternLength) {
            for (int i = 0; i < answerLength / patternLength; i++) {
                result += pattern;
            }
            result += pattern.substring(0, answerLength%patternLength);
        } else {
            result += pattern.substring(0, answerLength);
        }
        return result.split("");
    }

}
