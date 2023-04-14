package BOJ;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260 {
    private static int[][] graph = new int[1001][1001];
    private static boolean[] isVisited = new boolean[1001];

    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int M = sc.nextInt();
        int start = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = graph[y][x] = 1;
        }

        dfs(start);
        System.out.println();

        isVisited = new boolean[1001];

        bfs(start);
    }

    private static void dfs(int vertex){
        isVisited[vertex] = true;
        System.out.print(vertex + " ");

        for (int i = 1; i <= N; i++) {
            if (graph[vertex][i] == 1 && !isVisited[i]){
                dfs(i);
            }
        }
    }

    private static void bfs(int vertex){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        isVisited[vertex] = true;

        while(!queue.isEmpty()){
            int poll = queue.poll();
            System.out.print(poll + " ");

            for (int i = 1; i <= N; i++) {
                if (graph[poll][i] == 1 && !isVisited[i]){
                    queue.offer(i);
                    isVisited[i] = true;
                }
            }
        }
    }
}
