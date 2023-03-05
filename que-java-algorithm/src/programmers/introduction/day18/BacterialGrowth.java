package programmers.introduction.day18;

public class BacterialGrowth {
    public static void main(String[] args) {
        BacterialGrowth bacterialGrowth = new BacterialGrowth();
        System.out.println(bacterialGrowth.solution(2,10));
        System.out.println(bacterialGrowth.solution(7,15));
    }
    public int solution(int n, int t) {
        int answer = n;
        for (int i = 0; i < t; i++) {
            answer *= 2;
        }
        return answer;
    }
}
