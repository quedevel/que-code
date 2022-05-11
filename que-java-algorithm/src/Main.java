import java.util.Scanner;

public class Main {
    public static void solution(int[][] iArr){
        int cnt = 0;
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};
        for (int i = 0; i < iArr.length; i++) {
            for (int j = 0; j < iArr.length; j++) {
                boolean flag = true;
                for (int k = 0; k < x.length; k++) {
                    int dx = i+x[k];
                    int dy = j+y[k];
                    if (dx >= 0 && dx < iArr.length && dy >= 0 && dy < iArr.length && iArr[i][j] <= iArr[dx][dy]){
                        flag = false;
                    }
                }
                if (flag){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[][] iArr = new int[cnt][cnt];
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt; j++) {
                iArr[i][j] = sc.nextInt();
            }
        }
        solution(iArr);
    }
}
