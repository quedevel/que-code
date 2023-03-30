package programmers.level2;

import java.math.BigInteger;

public class FibonacciNumber {
    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        System.out.println(fibonacciNumber.solution(100000));
    }
    // 피보나치 수열?
    // F(0) = 0, F(1) = 1일 때,
    // F(n) = F(n-1) + F(n-2)
    // F(2) = F(1) + F(0) = 1 + 0 = 1
    // F(3) = F(2) + F(1) = F(1) + F(0) + F(1) = 1 + 0 + 1 = 2
    // F(4) = F(3) + F(2)
    public BigInteger solution(int n) {
        BigInteger before = BigInteger.valueOf(1);
        BigInteger after = BigInteger.valueOf(2);
        if (n == 2) return before;
        if (n == 3) return after;
        BigInteger fibonacciNumber = BigInteger.valueOf(0);
        for (int i = 4; i <= n; i++) {
            fibonacciNumber = after.add(before);
            before = after;
            after = fibonacciNumber;
        }
        return fibonacciNumber.remainder(BigInteger.valueOf(1234567));
    }

    // recursive 함수는 메모리를 더럽게 많이 먹는다! 실패!
    private static int getFibonacciNumber(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        return getFibonacciNumber(n-1) + getFibonacciNumber(n-2);
    }
}
