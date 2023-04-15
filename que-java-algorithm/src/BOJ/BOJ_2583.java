package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2583 {
    private static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    private static boolean[] isVisited;
    private static int[] parents;
    private static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());

        isVisited = new boolean[N+1];
        parents = new int[N+1];
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] split = sc.nextLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            tree.get(x).add(y);
            tree.get(y).add(x);
        }
        sc.close();

        dfs(1);

        for (int i = 2; i < parents.length; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void dfs(int vertex){
        isVisited[vertex] = true;
        ArrayList<Integer> list = tree.get(vertex);
        for (int i : list) {
            if (!isVisited[i]){
                parents[i] = vertex;
                dfs(i);
            }
        }
    }
}
