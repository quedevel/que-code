package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1707 {
    private static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int v = sc.nextInt();
            int e = sc.nextInt();
            graph = new ArrayList<>();
            for (int j = 0; j <= v; j++) {
                graph.add(new ArrayList<>());
            }
            for (int j = 0; j < e; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                graph.get(x).add(y);
                graph.get(y).add(x);
            }
            int[] colors = new int[v+1];

            for (int j = 1; j <= v; j++) {
                if(colors[j] == 0){
                    dfs(colors, j, 1);
                }
            }
            boolean pass = true;
            for (int j = 1; j <= v; j++) {
                for (int n : graph.get(j)) {
                    if (colors[n] == colors[j]){
                        pass = false;
                    }
                }
            }
            System.out.println(pass? "YES" : "NO");
        }
    }
    private static void dfs(int[] colors, int vertex, int color){
        colors[vertex] = color;
        for (int v : graph.get(vertex)) {
            if (colors[v] == 0){
                dfs(colors,v,3-color);
            }
        }
    }
}
