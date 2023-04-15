package BOJ;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2583 {

    private static int M;
    private static int N;
    private static int K;

    private static final int[] dx = {1,-1,0,0};
    private static final int[] dy = {0,0,1,-1};

    private static boolean[][] area;
    private static boolean[][] isVisited;
    private static int areaCount = 0;
    private static int areaSize = 1;
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        M = Integer.parseInt(split[0]);
        N = Integer.parseInt(split[1]);
        K = Integer.parseInt(split[2]);

        area = new boolean[M][N];
        isVisited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            String[] strings = sc.nextLine().split(" ");
            int x1 = Integer.parseInt(strings[0]);
            int y1 = Integer.parseInt(strings[1]);
            int x2 = Integer.parseInt(strings[2]);
            int y2 = Integer.parseInt(strings[3]);
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    area[j][k] = true;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j] && !area[i][j]){
                    areaCount++;
                    dfs(i,j);
                    list.add(areaSize);
                    areaSize = 1;
                }
            }
        }

        Collections.sort(list);
        System.out.println(areaCount);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    private static void dfs(int x , int y){
        isVisited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= M || ny >= N || isVisited[nx][ny]) continue;
            if (!area[nx][ny]){
                areaSize++;
                dfs(nx,ny);
            }
        }
    }
}
