package programmers.introduction.day17;

public class DigitSum {
    public static void main(String[] args) {
        DigitSum digitSum = new DigitSum();
        System.out.println(digitSum.solution(1234));
        System.out.println(digitSum.solution(930211));
    }
    public int solution(int n) {
        int answer = 0;
        String str = n+"";
        for (String s : str.split("")) {
            answer += Integer.valueOf(s);
        }
        return answer;
    }
}
