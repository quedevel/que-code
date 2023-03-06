package programmers.introduction.day9;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BallDivider {
    public static void main(String[] args) {
        BallDivider ballDivider = new BallDivider();
//        System.out.println(ballDivider.solution(3,2));
        System.out.println(ballDivider.solution(30,16));
    }
    public BigInteger solution(int balls, int share) {
        List<BigInteger> numerators = new ArrayList<>();
        List<BigInteger> denominators = new ArrayList<>();
        for (int i = balls; i > balls - share; i--) {
            numerators.add(BigInteger.valueOf(i));
        }
        for (int i = 1; i <= share; i++) {
            if (numerators.contains(BigInteger.valueOf(i))){
                numerators.remove(BigInteger.valueOf(i));
            } else {
                denominators.add(BigInteger.valueOf(i));
            }
        }

        BigInteger numerator = numerators.stream().reduce(BigInteger.valueOf(1L), (a, b) -> a.multiply(b));
        BigInteger denominator = denominators.stream().reduce(BigInteger.valueOf(1L), (a, b) -> a.multiply(b));
        return numerator.divide(denominator);
    }

}
