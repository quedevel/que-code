package BOJ;

import java.util.Scanner;

public class BOJ_2606 {

    private static int[][] graph;
    private static boolean[] isVisited;
    private static int M;
    private static int count = 0;

    private static void dfs(int vertex){
        isVisited[vertex] = true;
        count++;

        for (int i = 1; i <= M; i++) {
            if (graph[vertex][i] == 1 && !isVisited[i]){
                isVisited[i] = true;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        int N = sc.nextInt();

        graph = new int[M+1][M+1];
        isVisited = new boolean[M+1];

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = graph[y][x] = 1;
        }

        dfs(1);

        System.out.println(count-1);
        sc.close();
    }
}
