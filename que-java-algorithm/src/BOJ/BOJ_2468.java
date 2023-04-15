package BOJ;

import java.util.Scanner;

public class BOJ_2468 {
    private static int[][] map;
    private static boolean[][] isVisited;
    private static final int[] dx = {1,-1,0,0};
    private static final int[] dy = {0,0,1,-1};
    private static int N;
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(sc.nextLine());

        map = new int[N][N];
        isVisited = new boolean[N][N];

        int maxHeight = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            String[] split = sc.nextLine().split(" ");
            for (int j = 0; j < split.length; j++) {
                int h = Integer.parseInt(split[j]);
                if (h > maxHeight) maxHeight = h;
                map[i][j] = h;
            }
        }
        sc.close();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!isVisited[j][k] && map[j][k] > i){
                        dfs(j,k,i);
                        count++;
                    }
                }
            }
            if (count > max) max = count;
            isVisited = new boolean[N][N];
            count = 0;
        }
        System.out.println(max);
    }

    private static void dfs(int x, int y, int more){
        isVisited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || isVisited[nx][ny]) continue;
            if (map[nx][ny] > more){
                dfs(nx,ny,more);
            }
        }
    }
}
