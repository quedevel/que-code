package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    private static final int[] dx = {1,-1,0,0};
    private static final int[] dy = {0,0,1,-1};
    private static int[][] maze;
    private static boolean[][] visited;
    private static class Player{
        int x;
        int y;
        int distance;
        public Player(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().trim().split("");
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(split[j]);
            }
        }
        Queue<Player> queue = new LinkedList<>();
        queue.offer(new Player(0,0,1));
        visited[0][0] = true;
        while(!queue.isEmpty()){
            Player player = queue.poll();
            if (player.x == N-1 && player.y == M-1){
                System.out.println(player.distance);
                break;
            }
            for (int i = 0; i < dx.length; i++) {
                int nx = player.x + dx[i];
                int ny = player.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || maze[nx][ny] != 1) continue;
                queue.offer(new Player(nx,ny,player.distance+1));
                visited[nx][ny] = true;
            }
        }
    }
}
