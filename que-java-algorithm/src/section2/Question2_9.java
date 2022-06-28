package section2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Question2_9 {
    public static void solution(int[][] iArr){
        List<Integer> sumList = new ArrayList<>();
        int leftDiagonal = 0;
        int rightDiagonal = 0;
        for (int i = 0; i < iArr.length; i++) {
            int horizontal = 0;
            int vertical = 0;
            for (int j = 0; j < iArr.length; j++) {
                horizontal += iArr[i][j];
                vertical += iArr[j][i];
            }
            leftDiagonal += iArr[i][i];
            rightDiagonal += iArr[i][iArr.length-1-i];
            sumList.add(horizontal);
            sumList.add(vertical);
        }
        sumList.add(leftDiagonal);
        sumList.add(rightDiagonal);
        int max = sumList.stream().max(Comparator.comparing(Integer::intValue)).get();
        System.out.println(max);
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