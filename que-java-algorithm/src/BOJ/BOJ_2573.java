package BOJ;

import java.util.Scanner;

public class BOJ_2573 {

    private static int H;
    private static int W;
    private static int[][] graph;
    private static int[][] meltingCount;
    private static boolean[][] visited;
    private static final int[] dx = {1,-1,0,0};
    private static final int[] dy = {0,0,1,-1};
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        graph = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int year = 0;
        while(true){
            count = 0;
            visited = new boolean[H][W];
            meltingCount = new int[H][W];
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!visited[i][j] && graph[i][j] > 0){
                        count++;
                        dfs(i,j);
                    }
                }
            }
            if (count >= 2){
                break;
            } else if (count == 0){
                year = 0;
                break;
            }
            year++;
            graph = afterYear(graph, meltingCount);
        }
        System.out.println(year);
    }

    private static int[][] afterYear(int[][] graph, int[][] meltingCount){
        int[][] result = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (graph[i][j] > 0){
                    result[i][j] = Math.max(graph[i][j] - meltingCount[i][j], 0);
                }
            }
        }
        return result;
    }

    private static void dfs(int x, int y){
        if (count >= 2) return;
        visited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= H || ny >= W || visited[nx][ny]) continue;
            if (graph[nx][ny] == 0){
                meltingCount[x][y] += 1;
            } else {
                dfs(nx,ny);
            }
        }
    }
}
