package programmers.level1;

public class TernaryReverse {
    public static void main(String[] args) {
        TernaryReverse ternaryReverse = new TernaryReverse();
        System.out.println(ternaryReverse.solution(45));
        System.out.println(ternaryReverse.solution(125));

    }
    public int solution(int n) {
        String ternaryStr = Integer.toString(n , 3);
        StringBuffer stringBuffer = new StringBuffer(ternaryStr);
        String ternaryStrReverse = stringBuffer.reverse().toString();
        return Integer.parseInt(ternaryStrReverse,3);
    }
}
