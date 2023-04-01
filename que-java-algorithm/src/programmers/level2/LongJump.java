package programmers.level2;

public class LongJump {
    public static void main(String[] args) {
        LongJump longJump = new LongJump();
        System.out.println(longJump.solution(2000));
    }
    // DP (Dynamic Programming)
    // 동적 계획법은 큰 문제를 작은 문제로 나누어 푸는 분할 정복 기법과 유사합니다.
    // 하지만 동적 계획법은 중복 계산을 피하기 위해 계산 결과를 메모이제이션(Memoization)하여 재활용합니다.
    // 이러한 방식으로 풀이 시간을 대폭 줄일 수 있습니다.
    //
    // 동적 계획법은 최적화 문제와 결정 문제를 푸는 데에 자주 사용됩니다.
    // 예를 들어, 최단 경로 문제나 배낭 문제와 같은 문제들을 동적 계획법으로 효율적으로 해결할 수 있습니다.
    public long solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        long[] arr = new long[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = (arr[i-1]+arr[i-2])%1234567;
        }
        return arr[n-1];
    }
}
