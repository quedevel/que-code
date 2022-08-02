package codility.lesson.prime_and_composite_numbers;

public class CountFactors {
    // N is an integer within the range [1..2,147,483,647].
    public int solution(int N) {
        int result = 0;
        double sqrt = Math.sqrt(N);
        for (int i = 1; i < sqrt; i++) {
            if (N%i == 0) result++;
        }
        result *= 2;
        if (sqrt %1 == 0) result++;
        return result;
    }
    public static void main(String[] args) {
        CountFactors countFactors = new CountFactors();
        System.out.println(countFactors.solution(9));
    }
}
