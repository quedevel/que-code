package programmers.introduction.day20;

import java.util.Arrays;

public class RectangleAreaCalculator {
    public static void main(String[] args) {
        RectangleAreaCalculator rectangleAreaCalculator = new RectangleAreaCalculator();
        System.out.println(rectangleAreaCalculator.solution(new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 2}}));
        System.out.println(rectangleAreaCalculator.solution(new int[][]{{-1, -1}, {1, 1}, {1, -1}, {-1, 1}}));
    }
    public int solution(int[][] dots) {
        int[] widthX = new int[4];
        int[] heightY = new int[4];
        for (int i = 0; i < dots.length; i++) {
            widthX[i] = dots[i][0];
            heightY[i] = dots[i][1];
        }
        Arrays.sort(widthX);
        Arrays.sort(heightY);
        return Math.abs(widthX[3] - widthX[0]) * Math.abs(heightY[3] - heightY[0]);
    }
}
