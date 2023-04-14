package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1012 {

    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};

    private static int[][] area;
    private static boolean[][] isVisited;

    private static int count = 0;

    private static int w,h,k;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        int testCaseCount = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < testCaseCount; i++) {
            String[] split = sc.nextLine().split(" ");
            w = Integer.parseInt(split[0]);
            h = Integer.parseInt(split[1]);
            k = Integer.parseInt(split[2]);
            area = new int[h][w];
            isVisited = new boolean[h][w];
            count = 0;
            for (int j = 0; j < k; j++) {
                String[] coordinates = sc.nextLine().split(" ");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);
                area[y][x] = 1;
            }

            for (int j = 0; j < h; j++) {
                for (int l = 0; l < w; l++) {
                    if (!isVisited[j][l] && area[j][l] == 1){
                        count++;
                        dfs(j,l);
                    }
                }
            }
            list.add(count);
        }

        list.forEach(System.out::println);
    }

    private static void dfs(int x, int y){
        isVisited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= h || ny >= w || isVisited[nx][ny] || area[nx][ny] != 1){
                continue;
            }

            isVisited[nx][ny] = true;
            dfs(nx,ny);
        }
    }
}
