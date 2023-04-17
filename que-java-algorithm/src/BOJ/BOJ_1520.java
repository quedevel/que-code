package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1520 {
    private static int H,W;
    private static int[][] map, dp;
    private static final int[] dx = {1,-1,0,0};
    private static final int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        dp = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0,0));
    }

    private static int dfs(int x, int y){
        if (x == H-1 && y == W-1){
            return 1;
        }
        if (dp[x][y] != -1){
            return dp[x][y];
        } else {
            dp[x][y] = 0;
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if (map[x][y] > map[nx][ny]){
                    dp[x][y] += dfs(nx,ny);
                }
            }
        }
        return dp[x][y];
    }

    /*

    백트래킹 시간부족

    private static int H;
    private static int W;
    private static int[][] map;
    private static boolean[][] isVisited;
    private static int count = 0;
    private static final int[] dx = {1,-1,0,0};
    private static final int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        isVisited = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0,H-1,W-1);
        System.out.println(count);
    }

    private static void dfs(int x, int y, int destinationX, int destinationY){
        if(x == destinationX && y == destinationY){
            count++;
        } else {
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= H || ny >= W || isVisited[nx][ny] || map[nx][ny] >= map[x][y]) continue;
                isVisited[nx][ny] = true;
                dfs(nx, ny, destinationX, destinationY);
                isVisited[nx][ny] = false;
            }
        }
    }
    */
}
