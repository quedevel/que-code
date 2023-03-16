package programmers.level1;

public class IntegerSquareRootChecker {
    public static void main(String[] args) {
        IntegerSquareRootChecker integerSquareRootChecker = new IntegerSquareRootChecker();
        System.out.println(integerSquareRootChecker.solution(121L));
        System.out.println(integerSquareRootChecker.solution(3L));
    }
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        if (sqrt%1 == 0d){
            return (long) ((sqrt+1)*(sqrt+1));
        } else {
            return -1;
        }
    }
}
