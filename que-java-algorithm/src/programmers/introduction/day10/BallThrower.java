package programmers.introduction.day10;

public class BallThrower {
    public static void main(String[] args) {
        BallThrower ballThrower = new BallThrower();
        System.out.println(ballThrower.solution(new int[]{1,2,3,4},2));
        System.out.println(ballThrower.solution(new int[]{1,2,3,4,5,6},5));
        System.out.println(ballThrower.solution(new int[]{1,2,3},3));
    }
    public int solution(int[] numbers, int k) {
        int i = (1 + k * 2) % numbers.length;
        return i-2 <= 0? i+numbers.length-2: i-2;
    }
}
