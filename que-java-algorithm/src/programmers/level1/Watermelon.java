package programmers.level1;

public class Watermelon {
    public static void main(String[] args) {

    }
    public String solution(int n) {
        String answer = "";
        String even = "수박";
        String odd = "수";

        for (int i = 0; i < n / 2; i++) {
            answer += even;
        }

        if (n % 2 > 0){
            answer += odd;
        }

        return answer;
    }
}
