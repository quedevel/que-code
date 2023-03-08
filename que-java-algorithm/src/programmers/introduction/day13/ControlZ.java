package programmers.introduction.day13;

public class ControlZ {
    public static void main(String[] args) {
        ControlZ controlZ = new ControlZ();
        System.out.println(controlZ.solution("1 2 Z 3"));
        System.out.println(controlZ.solution("10 20 30 40"));
        System.out.println(controlZ.solution("10 Z 20 Z 1"));
        System.out.println(controlZ.solution("10 Z 20 Z"));
        System.out.println(controlZ.solution("-1 -2 -3 Z"));
    }
    public int solution(String s) {
        int answer = 0;
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("Z")){
                answer -= Integer.valueOf(split[i-1]);
            } else {
                answer += Integer.valueOf(split[i]);
            }
        }
        return answer;
    }
}
