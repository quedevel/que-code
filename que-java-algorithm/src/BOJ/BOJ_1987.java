package BOJ;

import java.util.Scanner;

public class BOJ_1987 {
    private static String[][] map;
    private static boolean[][] isVisited;
    private static final int[] dx = {1,-1,0,0};
    private static final int[] dy = {0,0,1,-1};
    private static int H;
    private static int W;
    private static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        H = Integer.parseInt(split[0]);
        W = Integer.parseInt(split[1]);
        map = new String[H][W];
        isVisited = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            String[] alphabets = sc.nextLine().split("");
            for (int j = 0; j < W; j++) {
                map[i][j] = alphabets[j];
            }
        }
        sc.close();

        dfs(0,0,map[0][0],1);

        System.out.println(max);
    }

    private static void dfs(int x, int y, String str, int depth){
        max = Math.max(max,depth);
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= H || ny >= W || isVisited[nx][ny] || str.contains(map[nx][ny])) continue;
            isVisited[nx][ny] = true;
            dfs(nx,ny, str+map[nx][ny], depth+1);
            isVisited[nx][ny] = false;
        }
    }
    /*

    BFS 메모리 부족 발생

    private static class Node {
        public final int x;
        public final int y;
        public final String alphabet;
        public final int depth;

        public boolean[][] isVisited;
        public Node(int x, int y, String alphabet, int depth, boolean[][] isVisited) {
            this.x = x;
            this.y = y;
            this.alphabet = alphabet;
            this.depth = depth;
            this.isVisited = isVisited;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        H = Integer.parseInt(split[0]);
        W = Integer.parseInt(split[1]);
        map = new String[H][W];
        isVisited = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            String[] alphabets = sc.nextLine().split("");
            for (int j = 0; j < W; j++) {
                map[i][j] = alphabets[j];
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0,map[0][0],1, isVisited));

        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            max = Math.max(max, node.depth);

            for (int i = 0; i < dx.length; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= H || ny >= W || node.isVisited[nx][ny] || node.alphabet.contains(map[nx][ny])) continue;
                boolean[][] newIsVisited = copyOf(node.isVisited);
                newIsVisited[nx][ny] = true;
                queue.offer(new Node(nx,ny,node.alphabet + map[nx][ny],node.depth+1, newIsVisited));
            }
        }
        System.out.println(max);
    }

    private static boolean[][] copyOf(boolean[][] original){
        boolean[][] result = new boolean[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                result[i][j] = original[i][j];
            }
        }
        return result;
    }
    */
}
