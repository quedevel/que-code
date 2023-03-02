package programmers.introduction.day2;

import java.util.Arrays;

public class FractionSum {

    public static void main(String[] args) {
        FractionSum fractionSum = new FractionSum();
        System.out.println(Arrays.toString(fractionSum.solution(1,2,3,4)));
        System.out.println(Arrays.toString(fractionSum.solution(9,2,1,3)));
    }

    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};
        if (validation(numer1) && validation(denom1)
                && validation(numer2) && validation(denom2)){
            int numer = numer1*denom2 + numer2*denom1;
            int denom = denom1*denom2;
            int gcd = getGCD(numer, denom);

            if(gcd > 1){
                numer = numer/gcd;
                denom = denom/gcd;
            }

            answer = new int[]{numer, denom};
        }
        return answer;
    }

    private static boolean validation(int n) {
        return n > 0 && n < 1000;
    }

    /**
     * 유클리드 호제법(Euclidean Algorithm)
     *
     * 두 양의 정수 a,b(a > b)에 대하여,
     * a = bq + r(0 <= r < b)라 하면,
     * a, b의 최대 공약수는 b, r의 최대 공약수와 같다.
     *
     * @param a
     * @param b
     * @return 최대 공약수
     */
    private static int getGCD(int a, int b) {
        return b==0? a : getGCD(b, a % b);
    }

}
