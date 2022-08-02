package codility.lesson.time_complexity;

public class TapeEquilibrium {

//    N is an integer within the range [2..100,000];
//    each element of array A is an integer within the range [−1,000..1,000].
    public int solution(int[] A) {
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        int left = 0;
        int right = 0;
        int min = 100000;
        for (int i = 0; i < A.length-1; i++) {
            left += A[i];
            right = sum - left;
            int abs = Math.abs(left - right);
            if (abs < min) min = abs;
        }
        return min;
    }

    public static void main(String[] args) {
        TapeEquilibrium t = new TapeEquilibrium();
        System.out.println(t.solution(new int[]{1,2,3,4,5}));
    }
}
