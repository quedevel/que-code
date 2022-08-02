package codility.lesson.time_complexity;

public class FrogJmp {
    public static int solution(int X, int Y, int D) {
        int add = 0;
        int quotient = (Y-X)/D;
        int remainder = (Y-X)%D;
        if (remainder > 0) add = 1;
        return quotient + add;
    }

    public static void main(String[] args) {
        System.out.println(solution(1, 1000000, 30));
    }
}
