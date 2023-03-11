package programmers.introduction.day16;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        System.out.println(stringCalculator.solution("3 + 7"));
        System.out.println(stringCalculator.solution("3 + 4 - 1"));
    }
    public int solution(String my_string) {
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
