package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1167 {
    static int N, max, maxNode;
    static boolean[] visited;
    static LinkedList<Node>[] graph;

    static class Node {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new LinkedList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) break;
                int w = Integer.parseInt(st.nextToken());
                graph[u].add(new Node(v, w));
            }
        }

        visited = new boolean[N + 1];
        dfs(1, 0);

        visited = new boolean[N + 1];
        dfs(maxNode, 0);

        System.out.println(max);
    }

    private static void dfs(int vertex, int sum) {
        visited[vertex] = true;
        if (sum > max) {
            max = sum;
            maxNode = vertex;
        }

        for (Node node : graph[vertex]) {
            if (!visited[node.v]) {
                dfs(node.v, sum + node.w);
            }
        }
    }
}
