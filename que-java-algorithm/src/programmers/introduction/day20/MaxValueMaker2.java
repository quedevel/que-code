package programmers.introduction.etc;

public class MaxValueMaker2 {
    public static void main(String[] args) {
        MaxValueMaker2 maxValueMaker2 = new MaxValueMaker2();
        System.out.println(maxValueMaker2.solution(new int[]{1, 2, -3, 4, -5}));
        System.out.println(maxValueMaker2.solution(new int[]{0, -31, 24, 10, 1, 9}));
        System.out.println(maxValueMaker2.solution(new int[]{10, 20, 30, 5, 5, 20, 5}));
    }
    public int solution(int[] numbers) {
        int answer = -100000000;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j){
                    if (numbers[i]*numbers[j] > answer) {
                        answer = numbers[i]*numbers[j];
                    }
                }
            }
        }
        return answer;
    }
}
