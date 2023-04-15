package BOJ;

import java.util.Scanner;

public class BOJ_4963 {
    private static String[][] map;
    private static boolean[][] isVisited;
    private static final int[] dx = {1,-1,0,0,1,-1,-1,1};
    private static final int[] dy = {0,0,1,-1,1,-1,1,-1};

    private static int W;
    private static int H;
    private static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            String[] wh = sc.nextLine().split(" ");
            W = Integer.parseInt(wh[0]);
            H = Integer.parseInt(wh[1]);
            if (W == 0 && H == 0) break;
            map = new String[H][W];
            isVisited = new boolean[H][W];
            for (int i = 0; i < H; i++) {
                String[] split = sc.nextLine().split(" ");
                for (int j = 0; j < split.length; j++) {
                    map[i][j] = split[j];
                }
            }
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!isVisited[i][j] && map[i][j].equals("1")){
                        dfs(i,j);
                        count++;
                    }
                }
            }

            System.out.println(count);
            count = 0;
        }
    }

    private static void dfs(int x, int y){
        isVisited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= H || ny >= W || isVisited[nx][ny] || !map[nx][ny].equals("1")) continue;
            dfs(nx,ny);
        }
    }
}
