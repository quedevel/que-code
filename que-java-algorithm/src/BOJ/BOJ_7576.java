package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
    private static int M;
    private static int N;
    private static final int[] dx = {1,-1,0,0};
    private static final int[] dy = {0,0,1,-1};
    private static int[][] box;
    private static int day = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        int cur = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                box[i][j] = tomato;
                if (tomato != -1) cur++;
                if (tomato == 1) q.offer(new int[]{i, j});
            }
        }
        if (cur == q.size()) {
            System.out.println(0);
            return;
        }
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curPos = q.poll();
                for (int j = 0; j < dx.length; j++) {
                    int nx = curPos[0] + dx[j];
                    int ny = curPos[1] + dy[j];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || box[nx][ny] != 0) continue;
                    box[nx][ny] = 1;
                    q.offer(new int[]{nx, ny});
                }
            }
            day++;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(day-1);
    }
}
