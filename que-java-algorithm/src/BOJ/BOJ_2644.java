package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2644 {

    private static int[][] area;
    private static boolean[] isVisited;
    private static int N;
    private static int M;
    private static class Node {
        public final int x;
        public final int depth;
        public Node(int x, int depth) {
            this.x = x;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        area = new int[N+1][N+1];
        isVisited = new boolean[N+1];

        String[] split = sc.nextLine().split(" ");
        int start = Integer.parseInt(split[0]);
        int destination = Integer.parseInt(split[1]);

        M = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < M; i++) {
            String[] strings = sc.nextLine().split(" ");
            int x = Integer.parseInt(strings[0]);
            int y = Integer.parseInt(strings[1]);
            area[x][y] = area[y][x] = 1;
        }
        sc.close();

        System.out.println(bfs(start, destination));
    }

    private static int bfs(int start, int destination){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));
        isVisited[start] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            if (node.x == destination){
                return node.depth;
            }

            for (int i = 1; i <= N; i++) {
                if (!isVisited[i] && area[node.x][i] == 1){
                    isVisited[i] = true;
                    queue.offer(new Node(i, node.depth+1));
                }
            }
        }
        return -1;
    }
}
