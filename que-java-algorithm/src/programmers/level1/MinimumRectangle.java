package programmers.level1;

public class MinimumRectangle {
    public static void main(String[] args) {
        MinimumRectangle minimumRectangle = new MinimumRectangle();
        System.out.println(minimumRectangle.solution(new int[][]{{60,50},{30,70},{60,30},{80,40}}));
        System.out.println(minimumRectangle.solution(new int[][]{{10,7},{12,3},{8,15},{14,7},{5,15}}));
        System.out.println(minimumRectangle.solution(new int[][]{{14,4},{19,6},{6,16},{18,7},{7,11}}));
    }
    public int solution(int[][] sizes) {
        int widthMax = 0;
        int heightMax = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            if (sizes[i][0] > widthMax){
                widthMax = sizes[i][0];
            }
            if (sizes[i][1] > heightMax){
                heightMax = sizes[i][1];
            }
        }
        return widthMax * heightMax;
    }

}
