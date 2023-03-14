package programmers.introduction.day24;

public class KCounter {
    public static void main(String[] args) {
        KCounter kCounter = new KCounter();
        System.out.println(kCounter.solution(1,13,1));
        System.out.println(kCounter.solution(10,50,5));
        System.out.println(kCounter.solution(3,10,2));
    }
    public int solution(int i, int j, int k) {
        int answer = 0;
        String kStr = k+"";
        for (int l = i; l < j+1; l++) {
            String s = l + "";
            String[] split = s.split("");
            for (int m = 0; m < split.length; m++) {
                if (split[m].equals(kStr)){
                    answer++;
                }
            }
        }
        return answer;
    }
}
