package programmers.introduction.day12;

public class HiddenNumberAddition {
    public static void main(String[] args) {
        HiddenNumberAddition hiddenNumberAddition = new HiddenNumberAddition();
        System.out.println(hiddenNumberAddition.solution("aAb1B2cC34oOp"));
        System.out.println(hiddenNumberAddition.solution("1a2b3c4d123"));
    }
    public int solution(String my_string) {
        int answer = 0;
        for (char c : my_string.toCharArray()){
            if(c >= 49 && c <= 57) answer += Integer.valueOf(c+"");
        }
        return answer;
    }
}
