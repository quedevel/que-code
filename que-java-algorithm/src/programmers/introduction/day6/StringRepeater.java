package programmers.introduction.day6;

public class StringRepeater {
    public static void main(String[] args) {
        StringRepeater stringRepeater = new StringRepeater();
        System.out.println(stringRepeater.solution("hello",3));
    }
    public String solution(String my_string, int n) {
        String answer = "";
        String[] split = my_string.split("");
        for (String s : split) {
            for (int i = 0; i < n; i++) {
                answer += s;
            }
        }
        return answer;
    }
}
