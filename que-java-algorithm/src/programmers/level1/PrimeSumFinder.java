package programmers.level1;


public class PrimeSumFinder {
    public static void main(String[] args) {
        PrimeSumFinder primeSumFinder = new PrimeSumFinder();
        System.out.println(primeSumFinder.solution(new int[]{1,2,3,4}));
        System.out.println(primeSumFinder.solution(new int[]{1,2,7,6,4}));
    }
    public int solution(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
