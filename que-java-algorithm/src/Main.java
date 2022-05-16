import java.util.*;

public class Main {
    public static void solution(int cnt, int[][] iArr){
        int result = 0, max = Integer.MIN_VALUE;
        for (int i = 1; i <= cnt; i++) {
            int count = 0;
            for (int j = 1; j <= cnt; j++) {
                for (int k = 1; k < 6; k++) {
                    if (iArr[i][k] == iArr[j][k]){
                        count++;
                        break;
                    }
                }
            }
            if (count > max){
                max = count;
                result = i;
            }
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[][] iArr = new int[cnt+1][6];
        for (int i = 1; i <= cnt; i++) {
            for (int j = 1; j <= 5; j++) {
                iArr[i][j] = sc.nextInt();
            }
        }
        solution(cnt, iArr);
    }
}
