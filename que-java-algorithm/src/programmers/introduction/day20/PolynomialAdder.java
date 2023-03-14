package programmers.introduction.day20;

import java.util.ArrayList;
import java.util.List;

public class PolynomialAdder {
    public static void main(String[] args) {
        PolynomialAdder polynomialAdder = new PolynomialAdder();
        System.out.println(polynomialAdder.solution("3x + 7 + x"));
        System.out.println(polynomialAdder.solution("3 + 99x + x"));
        System.out.println(polynomialAdder.solution("x + x + 99x"));
        System.out.println(polynomialAdder.solution("99 + 99 + 99"));
    }
    public String solution(String polynomial) {
        String answer = "";
        String[] split = polynomial.split(" ");

        List<Integer> xList = new ArrayList<>();
        List<Integer> sList = new ArrayList<>();

        for (String s : split) {
            if (s.indexOf("x") >= 0){
                if (s.length() > 1){
                    xList.add(Integer.valueOf(s.replace("x","")));
                } else {
                    xList.add(1);
                }
            } else if (s.indexOf("+") == -1){
                sList.add(Integer.valueOf(s));
            }
        }

        int c = xList.stream().reduce(0, (a,b) -> a+b);
        int d = sList.stream().reduce(0, (a,b) -> a+b);

        if (c > 0){
            if (c == 1){
                answer += "x";
            } else {
                answer += c+"x";
            }
        }

        if (c > 0 && d > 0){
            answer += " + ";
        }

        if (d > 0){
            answer += d;
        }

        return answer;
    }
}
