package BOJ;

import java.util.Scanner;

public class BOJ_11724 {

    private static int[][] area;
    private static boolean[] isVisited;
    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};
    private static int N, M;
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        area = new int[1001][1001];
        isVisited = new boolean[1001];

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            area[u][v] = area[v][u] = 1;
        }
        sc.close();

        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]){
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int vertex){
        isVisited[vertex] = true;
        for (int i = 1; i <= N; i++) {
            if (area[vertex][i] == 1 && !isVisited[i]){
                dfs(i);
            }
        }
    }
}
