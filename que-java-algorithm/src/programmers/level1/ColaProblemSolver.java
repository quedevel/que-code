package programmers.level1;

public class ColaProblemSolver {
    public static void main(String[] args) {
        ColaProblemSolver colaProblemSolver = new ColaProblemSolver();
        System.out.println(colaProblemSolver.solution(2,1,20));
        System.out.println(colaProblemSolver.solution(3,1,20));
    }
    public int solution(int a, int b, int n) {
        int total = 0;
        int remain;
        while(true) {
            int cur = b*(n/a);
            total += cur;
            remain = n%a;
            n = remain + cur;
            if (cur + remain < a){
                break;
            }
        }
        return total;
    }
}
