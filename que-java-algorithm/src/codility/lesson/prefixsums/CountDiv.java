package codility.lesson.prefixsums;

public class CountDiv {
//    A and B are integers within the range [0..2,000,000,000];
//    K is an integer within the range [1..2,000,000,000];
//    A ≤ B.
    public int solution(int A, int B, int K) {
        if (A%K == 0) return B/K - A/K + 1;
        else return B/K - A/K;
    }

    public static void main(String[] args) {
        CountDiv c = new CountDiv();
        System.out.println(c.solution(5,11,5));
    }
}
