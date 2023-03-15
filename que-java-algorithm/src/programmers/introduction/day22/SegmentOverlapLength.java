package programmers.introduction.day22;

public class SegmentOverlapLength {
    public static void main(String[] args) {
        SegmentOverlapLength segmentOverlapLength = new SegmentOverlapLength();
        System.out.println(segmentOverlapLength.solution(new int[][]{{-3,-1},{-2,1},{0,2}}));
        System.out.println(segmentOverlapLength.solution(new int[][]{{0,1},{2,5},{3,9}}));
        System.out.println(segmentOverlapLength.solution(new int[][]{{-1,1},{1,3},{3,9}}));
        System.out.println(segmentOverlapLength.solution(new int[][]{{0,5},{3,9},{1,10}}));
    }
    public int solution(int[][] lines) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length; j++) {
                if (min > lines[i][j]) min = lines[i][j];
                if (max < lines[i][j]) max = lines[i][j];
            }
        }

        int[] arr = new int[max - min + 1];
        for (int i = 0; i < lines.length; i++) {
            for (int j = lines[i][0]; j < lines[i][1]; j++) {
                arr[j-min] = arr[j-min] == 2? 2 : arr[j-min]+1;
            }
        }
        for (int i : arr) {
            if (i == 2) answer++;
        }
        return answer;
    }
}
