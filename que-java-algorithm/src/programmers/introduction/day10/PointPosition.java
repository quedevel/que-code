package programmers.introduction.day10;

public class PointPosition {
    public static void main(String[] args) {
        PointPosition pointPosition = new PointPosition();
        System.out.println(pointPosition.solution(new int[]{2,4}));
        System.out.println(pointPosition.solution(new int[]{-7,9}));
    }
    public int solution(int[] dot) {
        return dot[0]>0? dot[1]>0? 1 : 4 : dot[1]>0? 2 : 3;
    }
}
