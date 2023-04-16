package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_2667 {
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static int[][] area;
    private static boolean[][] isVisited;
    private static int N;
    private static int count = 0, number = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        N = Integer.parseInt(sc.nextLine());

        area = new int[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] nextLine = sc.nextLine().split("");
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(nextLine[j]);
            }
        }
        sc.close();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j] && area[i][j] == 1){
                    count = 0;
                    number++;
                    dfs(i,j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);
        System.out.println(number);
        list.forEach(System.out::println);
    }

    private static void dfs(int x, int y){
        isVisited[x][y] = true;
        count++;
        for (int i = 0; i < dx.length; i++) {
            // 한칸씩 이동
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || isVisited[nx][ny] || area[nx][ny] != 1) continue;
            isVisited[nx][ny] = true;
            dfs(nx, ny);
        }
    }
}
