package programmers.level2;

public class MinMaxFinder {
    public static void main(String[] args) {
        MinMaxFinder minMaxFinder = new MinMaxFinder();
        System.out.println(minMaxFinder.solution("1 2 3 4"));
        System.out.println(minMaxFinder.solution("-1 -2 -3 -4"));
        System.out.println(minMaxFinder.solution("-1 -1"));
    }
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            int sInteger = Integer.parseInt(split[i]);
            if (sInteger > max) max = sInteger;
            if (sInteger < min) min = sInteger;
        }
        return min+" "+max;
    }
}
