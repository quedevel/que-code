package programmers.level2;

import java.util.Arrays;

public class LeastCommonMultiple {
    public static void main(String[] args) {
        LeastCommonMultiple leastCommonMultiple = new LeastCommonMultiple();
        System.out.println(leastCommonMultiple.solution(new int[]{2,6,8,14})); // 168
        System.out.println(leastCommonMultiple.solution(new int[]{1,2,3})); // 6
    }
    public int solution(int[] arr) {
        return Arrays.stream(arr).reduce(1, LeastCommonMultiple::getLCM);
    }

    // 최대 공약수
    private static int getGCD(int a, int b) {
        return b == 0? a : getGCD(b, a%b);
    }

    // 최소 공배수
    private static int getLCM(int a, int b){
        return a*b/getGCD(a,b);
    }
}
