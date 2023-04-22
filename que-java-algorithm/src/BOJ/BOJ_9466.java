package BOJ;

import java.util.Scanner;

public class BOJ_9466 {
    private static int[] choices;
    private static boolean[] visited;
    private static boolean[] formed;
    private static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            choices = new int[N+1];
            visited = new boolean[N+1];
            formed = new boolean[N+1];
            count = 0;
            for (int j = 1; j <= N; j++) {
                int target = sc.nextInt();
                choices[j] = target;
                if (j == target){
                    visited[j] = true;
                    formed[j] = true;
                    count++;
                }
            }
            for (int j = 1; j <= N; j++){
                if (!visited[j]){
                    dfs(j);
                }
            }
            System.out.println(N - count);
        }
    }
    private static void dfs(int vertex){
        visited[vertex] = true;
        int next = choices[vertex];

        if(!visited[next]){
            dfs(next);
        } else {
            if(!formed[next]){
                for (int i = next; i != vertex; i = choices[i]) {
                    count++;
                }
                count++;
            }
        }
        formed[vertex] = true;
    }
}
