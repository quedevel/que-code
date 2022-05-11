package section2;

import java.util.Scanner;

public class Question22 {
    public static void solution(int[][] iArr){
        int cnt = 0;
        int[][] temp = new int[iArr.length+2][iArr.length+2];
        for (int i = 1; i < temp.length-1; i++) {
            for (int j = 1; j < temp.length-1; j++) {
                temp[i][j] = iArr[i-1][j-1];
            }
        }

        for (int i = 1; i < temp.length-1; i++) {
            for (int j = 1; j < temp.length-1; j++) {
                if (temp[i][j] > temp[i+1][j]
                        && temp[i][j] > temp[i][j+1]
                        && temp[i][j] > temp[i-1][j]
                        && temp[i][j] > temp[i][j-1]){
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