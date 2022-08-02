package codility.lesson.prefix_sums;


public class PassingCars {
//    N is an integer within the range [1..100,000];
//    each element of array A is an integer that can have one of the following values: 0, 1.
    public int solution(int[] A) {
        int sum = 0, prefix = 0;
        for (int num : A) {
            if (num == 0){
                prefix++;
            } else {
                sum += prefix;
            }
        }
        if (sum > 1000000000 || sum < 0) return -1;
        return sum;
    }

    public static void main(String[] args) {
        PassingCars c = new PassingCars();
        System.out.println(c.solution(new int[]{1}));
    }
}
