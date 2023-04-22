package BOJ;

import java.util.Scanner;

public class BOJ_1937 {
    private static final int[] dx = {1,-1,0,0};
    private static final int[] dy = {0,0,1,-1};
    private static int[][] forest;
    private static int[][] cache;
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        forest = new int[N][N];
        cache = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                forest[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, dfs(i,j));
            }
        }
        System.out.println(max);
    }

    private static int dfs(int x, int y){
        if (cache[x][y] != 0) return cache[x][y];
        cache[x][y] = 1;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= forest.length || ny >= forest.length) continue;
            if (forest[x][y] < forest[nx][ny]) cache[x][y] = Math.max(cache[x][y], dfs(nx,ny)+1);
        }
        return cache[x][y];
    }
}
