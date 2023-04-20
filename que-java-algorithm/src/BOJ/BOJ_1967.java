package BOJ;

import java.util.Scanner;

public class BOJ_1967 {
    private static int max = 0;
    private static boolean[] visited;
    private static Node[] graph;
    private static class Node {
        public final int v;
        public final int weight;
        public final Node edge;
        public Node (int v, int weight, Node edge) {
            this.v = v;
            this.weight = weight;
            this.edge = edge;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        graph = new Node[N+1];
        for (int i = 0; i < N-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            graph[u] = new Node(v, weight, graph[u]);
            graph[v] = new Node(u, weight, graph[v]);
        }
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            visited[i] = true;
            dfs(i,0);
        }
        System.out.println(max);
    }
    private static void dfs(int vertex, int sum){
        max = Math.max(max, sum);
        for (Node node = graph[vertex]; node != null; node = node.edge) {
            if (!visited[node.v]){
                visited[node.v] = true;
                dfs(node.v, sum + node.weight);
            }
        }
    }
}
