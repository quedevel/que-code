package programmers.introduction.day8;

public class PairCount {
    public static void main(String[] args) {
        PairCount pairCount = new PairCount();
        System.out.println(pairCount.solution(20));
        System.out.println(pairCount.solution(100));
    }
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if(n%i == 0) answer++;
        }
        return answer;
    }

}
