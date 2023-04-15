package BOJ;

import java.util.Scanner;

public class BOJ_10026 {

    private static String[][] colors;
    private static boolean[][] isVisited;
    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};
    private static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = Integer.parseInt(sc.nextLine());
        colors = new String[1001][1001];
        isVisited = new boolean[1001][1001];

        for (int i = 0; i < M; i++) {
            String[] split = sc.nextLine().split("");
            for (int j = 0; j < M; j++) {
                colors[i][j] = split[j];
            }
        }
        sc.close();

        int normal = 0;
        // normal
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j]){
                    dfs(i,j);
                    normal++;
                }
            }
        }

        isVisited = new boolean[1001][1001];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (colors[i][j].equals("G")) colors[i][j] = "R";
            }
        }
        int abnormal = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j]){
                    dfs(i,j);
                    abnormal++;
                }
            }
        }
        System.out.println(normal + " " + abnormal);
    }
    // R: Red
    // G: Green
    // B: Blue
    private static void dfs(int x, int y){
        isVisited[x][y] = true;
        String color = colors[x][y];
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= M || ny >= M || isVisited[nx][ny] || !color.equals(colors[nx][ny])) continue;
            isVisited[nx][ny] = true;
            dfs(nx,ny);
        }
    }
}
