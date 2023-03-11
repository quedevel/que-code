package programmers.introduction.day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OXQuiz {
    public static void main(String[] args) {
        OXQuiz oxQuiz = new OXQuiz();
        System.out.println(Arrays.toString(oxQuiz.solution(new String[]{"3 - 4 = -3", "5 + 6 = 11"})));
        System.out.println(Arrays.toString(oxQuiz.solution(new String[]{"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"})));
    }
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int i = 0;
        for (String s : quiz) {
            String[] split = s.split(" = ");
            if (calculator(split[0]) == Integer.valueOf(split[1])){
                answer[i] = "O";
            } else {
                answer[i] = "X";
            }
            i++;
        }
        return answer;
    }

    public static int calculator(String my_string) {
        String cal = "+";

        List<Integer> list = new ArrayList<>();

        String[] split = my_string.split(" ");

        for (int i = 0; i < split.length; i++) {
            if (i%2 == 0){
                if (cal.equals("-")){
                    list.add(Integer.valueOf(split[i])*-1);
                } else {
                    list.add(Integer.valueOf(split[i]));
                }
            } else {
                cal = split[i];
            }
        }

        return list.stream().reduce(0, (a,b) -> a+b);
    }
}
