package programmers.level2;

public class TargetNumber {
    public static void main(String[] args) {
        TargetNumber targetNumber = new TargetNumber();
        System.out.println(targetNumber.solution(
                new int[]{1,1,1,1,1},
                3
        ));
        System.out.println(targetNumber.solution(
                new int[]{4,1,2,1},
                4
        ));
    }
    int count = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        this.dfs(numbers, 0, target, 0);
        answer = this.count;
        this.count = 0;
        return answer;
    }

    /**
     * 깊이 우선 탐색
     * 모든 경우의 수 탐색
     * 느릴 수 있으나 구현은 더 쉬움
     * @param numbers
     * @param dept
     * @param target
     * @param sum
     */
    private void dfs(int[] numbers, int dept, int target, int sum){
        if (numbers.length == dept){
            if(target == sum) this.count++;
        } else {
            dfs(numbers, dept+1, target, sum+numbers[dept]);
            dfs(numbers, dept+1, target, sum-numbers[dept]);
        }
    }
}
