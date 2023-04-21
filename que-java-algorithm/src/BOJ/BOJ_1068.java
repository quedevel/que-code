package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1068 {
    private static int N;
    private static boolean[] visited;
    private static int[][] graph;
    private static int leafCount = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new int[N][N];
        visited = new boolean[N];
        int root = 0;
        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            if (input != -1){
                graph[input][i] = 1;
                graph[i][input] = 1;
            } else {
                root = i;
            }
        }

        int target = sc.nextInt();
        sc.close();

        removeTarget(target);

        if (root != target){
            bfs(root);
        }
        System.out.println(leafCount);
    }
    private static void bfs(int vertex){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        visited[vertex] = true;
        while(!queue.isEmpty()){
            int poll = queue.poll();
            int leaf = 0;
            for (int i = 0; i < N; i++) {
                if (!visited[i] && graph[poll][i] == 1){
                    leaf++;
                    visited[i] = true;
                    queue.offer(i);
                }
            }
            if (leaf == 0){
                leafCount++;
            }
        }
    }


    private static void removeTarget(int target){
        for (int i = 0; i < N; i++) {
            graph[target][i] = 0;
            graph[i][target] = 0;
        }
    }
}
