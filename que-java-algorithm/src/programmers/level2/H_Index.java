package programmers.level2;

import java.util.Arrays;

public class H_Index {
    public static void main(String[] args) {
        H_Index h_index = new H_Index();
        System.out.println(h_index.solution(new int[]{3,0,6,1,5}));
        System.out.println(h_index.solution(new int[]{10,8,5,4,3}));
        System.out.println(h_index.solution(new int[]{25,8,5,3,3}));
        System.out.println(h_index.solution(new int[]{0,0,0,0}));
    }
    // 6 5 3 1 0
    // 1 2 3 4 5
    public int solution(int[] citations) {
        int h = -1;
        Arrays.sort(citations);
        int[] sorted = new int[citations.length+1];
        int index = 1;
        for (int i = citations.length-1; i >= 0; i--) {
            sorted[index] = citations[i];
            index++;
        }
        for (int i = 1; i < sorted.length; i++) {
            if (i > sorted[i]) {
                h = i-1;
                break;
            } else if ( i == sorted[i]){
                h = i;
                break;
            }
            h = citations.length;
        }
        return h <= 0? 1 : h;
    }
}
