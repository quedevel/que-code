package programmers.level1;

public class StrangeStringMaker {
    public static void main(String[] args) {
        StrangeStringMaker strangeStringMaker = new StrangeStringMaker();
        System.out.println(strangeStringMaker.solution("trya helload aworld"));
    }
    public String solution(String s) {
        String answer = "";
        String[] split = s.toLowerCase().split("");
        int index = 0;
        for (int i = 0; i < split.length; i++) {
            if (" ".equals(split[i])){
                index = 0;
            } else if (isEven(index)){
                split[i] = split[i].toUpperCase();
                index++;
            } else if (!isEven(index)){
                index++;
            }
            answer += split[i];
        }
        return answer;
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
