package programmers.level1;

import java.math.BigInteger;
import java.util.Arrays;

public class XSpacingNumbers {
    public static void main(String[] args) {
        XSpacingNumbers xSpacingNumbers = new XSpacingNumbers();
        System.out.println(Arrays.toString(xSpacingNumbers.solution(2,5)));
        System.out.println(Arrays.toString(xSpacingNumbers.solution(4,3)));
        System.out.println(Arrays.toString(xSpacingNumbers.solution(-10000000,1000)));
    }
    public BigInteger[] solution(int x, int n) {
        BigInteger[] answer = new BigInteger[n];
        int i = 0;
        while(true){
            answer[i] = BigInteger.valueOf(x).multiply(BigInteger.valueOf(i+1));
            i++;
            if (i == n) break;
        }
        return answer;
    }
}
