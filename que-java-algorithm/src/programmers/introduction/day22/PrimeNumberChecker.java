package programmers.introduction.day22;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        PrimeNumberChecker primeNumberChecker = new PrimeNumberChecker();
        System.out.println(primeNumberChecker.solution(12,24));
        System.out.println(primeNumberChecker.solution(11,22));
        System.out.println(primeNumberChecker.solution(12,21));
//        System.out.println(primeNumberChecker.solution(1,1));
//        System.out.println(primeNumberChecker.solution(1,1000));
//        System.out.println(primeNumberChecker.solution(1000,1));
//        System.out.println(primeNumberChecker.solution(200,2));


    }
    public int solution(int a, int b) {
        int gcd = a > b? getGCD(b, a) : getGCD(a, b);
        b /= gcd;
        while(b != 1){
            if (b%2 == 0){
                b /= 2;
            } else if (b%5 == 0) {
                b /= 5;
            } else {
                return 2;
            }
        }
        return 1;
    }

    private static int getGCD(int a, int b) {
        return b == 0? a : getGCD(b, a % b);
    }
}
