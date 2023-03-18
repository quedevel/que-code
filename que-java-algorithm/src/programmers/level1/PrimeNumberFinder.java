package programmers.level1;

import java.util.Arrays;

public class PrimeNumberFinder {
    public static void main(String[] args) {
        PrimeNumberFinder primeNumberFinder = new PrimeNumberFinder();
        System.out.println(primeNumberFinder.solution(10));
        System.out.println(primeNumberFinder.solution(5));
    }
    public int solution(int n) {
        boolean[] isPrime = new boolean[n+1];  // 초기값 false
        Arrays.fill(isPrime, true);  // 모든 수를 소수로 초기화

        // 에라토스테네스의 체 알고리즘
        // 1. 2부터 n까지의 모든 수를 적는다.
        // 2. 아직 지워지지 않은 수 중에서 가장 작은 수를 찾는다. 이 수는 소수이다.
        // 3. 이제 이 소수의 배수를 모두 지운다.
        // 4. 위 과정을 반복하면서 더 이상 지울 수 있는 수가 없을 때까지 반복한다.
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;  // 소수의 배수를 지움
                }
            }
        }

        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                answer++;
            }
        }
        return answer;
    }

}
