package programmers.introduction.day22;


public class Parallel {
    public static void main(String[] args) {
        Parallel parallel = new Parallel();
        
        System.out.println(parallel.solution(new int[][]{{1,4},{9,2},{3,8},{11,6}}));
        System.out.println(parallel.solution(new int[][]{{3,5},{4,1},{2,4},{5,10}}));

        System.out.println(parallel.solution(new int[][]{{1,0},{2,1},{3,1},{5,0}}));
        System.out.println(parallel.solution(new int[][]{{1,0},{1,5},{3,1},{3,3}}));
    }
    public int solution(int[][] dots) {
        int x1 = dots[0][0];
        int y1 = dots[0][1];
        int x2 = dots[1][0];
        int y2 = dots[1][1];
        int x3 = dots[2][0];
        int y3 = dots[2][1];
        int x4 = dots[3][0];
        int y4 = dots[3][1];

        if (Math.abs((x1 - x2) * (y3 - y4)) == Math.abs((y1 - y2) * (x3 - x4))) {
            return 1;
        }
        if (Math.abs((x1 - x3) * (y2 - y4)) == Math.abs((y1 - y3) * (x2 - x4))) {
            return 1;
        }
        if (Math.abs((x1 - x4) * (y2 - y3)) == Math.abs((y1 - y4) * (x2 - x3))) {
            return 1;
        }
        return 0;
    }
}
