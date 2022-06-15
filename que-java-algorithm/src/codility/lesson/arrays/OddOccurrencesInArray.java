package codility.lesson.arrays;

public class OddOccurrencesInArray {
    public static int solution(int[] A) {
        // XOR 연산
        // 같은 값이 서로 XOR 연산을 하게되면 0000이 된다.
        int result = 0;
        for (int num : A) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        solution(new int[]{1,2,3,1,4,5});
    }
}
