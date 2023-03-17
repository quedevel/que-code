package programmers.level1;

public class HarshadNumber {
    public static void main(String[] args) {
        HarshadNumber harshadNumber = new HarshadNumber();
        System.out.println(harshadNumber.solution(10));
        System.out.println(harshadNumber.solution(12));
        System.out.println(harshadNumber.solution(11));
        System.out.println(harshadNumber.solution(13));
    }
    public boolean solution(int x) {
        String str = x+"";
        String[] split = str.split("");
        int sum = 0;
        for (int i = 0; i < split.length; i++) {
            sum += Integer.valueOf(split[i]);
        }
        return x%sum == 0;
    }
}
