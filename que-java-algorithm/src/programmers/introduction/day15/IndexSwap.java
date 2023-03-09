package programmers.introduction.day15;

public class IndexSwap {
    public static void main(String[] args) {
        IndexSwap indexSwap = new IndexSwap();
        System.out.println(indexSwap.solution("hello",1,2));
        System.out.println(indexSwap.solution("i love you",3,6));
    }
    public String solution(String my_string, int num1, int num2) {
        String answer = "";

        String[] split = my_string.split("");
        String temp = split[num1];
        split[num1] = split[num2];
        split[num2] = temp;

        for (String s : split) {
            answer += s;
        }

        return answer;
    }
}
