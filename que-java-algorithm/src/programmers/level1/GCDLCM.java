package programmers.level1;

// GCDLCM (Greatest Common Divisor and Least Common Multiple)
public class GCDLCM {
    public static void main(String[] args) {

    }
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int gcd = n > m ? getGCD(n,m) : getGCD(m,n);
        answer[0] = gcd;
        answer[1] = n*m/gcd;
        return answer;
    }

    private static int getGCD(int a, int b) {
        return b == 0? a : getGCD(b, a%b);
    }
}
