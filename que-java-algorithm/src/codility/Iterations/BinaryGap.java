package codility.Iterations;

import java.util.ArrayList;
import java.util.List;

public class BinaryGap {

    public static int solution(int N) {
        char[] cArr = Integer.toBinaryString(N).toCharArray();
        List<Integer> indexs = new ArrayList<>();

        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] == '1') indexs.add(i);
        }

        int max = 0;

        for (int i = 0; i < indexs.size(); i++) {
            if (i+1 < indexs.size()){
                int current = indexs.get(i+1) - indexs.get(i) - 1;
                if (max < current){
                    max = current;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        solution(32);
    }
}
