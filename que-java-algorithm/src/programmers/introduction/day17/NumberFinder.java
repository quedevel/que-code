package programmers.introduction.day17;

public class NumberFinder {
    public static void main(String[] args) {
        NumberFinder numberFinder = new NumberFinder();
        System.out.println(numberFinder.solution(29183,1));
        System.out.println(numberFinder.solution(232443,4));
        System.out.println(numberFinder.solution(123456,7));
    }
    public int solution(int num, int k) {
        int answer = -1;

        String numStr = num+"";
        String kStr = k+"";
        String[] split = numStr.split("");
        for (int i = 0; i < split.length; i++) {
            if (kStr.equals(split[i])){
                answer = i+1;
                break;
            }
        }

        return answer;
    }
}
