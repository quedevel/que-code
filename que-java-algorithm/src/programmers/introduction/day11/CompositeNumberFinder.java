package programmers.introduction.day11;

public class CompositeNumberFinder {
    public static void main(String[] args) {
        CompositeNumberFinder compositeNumberFinder = new CompositeNumberFinder();
        System.out.println(compositeNumberFinder.solution(10));
        System.out.println(compositeNumberFinder.solution(15));
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j*j <= i; j++) {
                if (j*j == i) {
                    cnt++;
                } else if (i%j == 0){
                    cnt+=2;
                }
                if (cnt >= 3){
                    break;
                }
            }
            if(cnt >= 3){
                answer++;
            }
        }
        return answer;
    }


}
