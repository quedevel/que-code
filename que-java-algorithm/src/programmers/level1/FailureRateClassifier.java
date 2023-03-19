package programmers.level1;

import java.util.*;

public class FailureRateClassifier {
    public static void main(String[] args) {
        FailureRateClassifier failureRateClassifier = new FailureRateClassifier();
        System.out.println(Arrays.toString(failureRateClassifier.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(failureRateClassifier.solution(4, new int[]{4,4,4,4,4})));
    }
    public int[] solution(int N, int[] stages) {
        int[] failCount = new int[N + 1];
        for (int stage : stages) {
            if (stage <= N) {
                failCount[stage]++;
            }
        }

        int totalCount = stages.length;
        double[] failRate = new double[N];
        for (int i = 0; i < N; i++) {
            if (totalCount == 0) {
                failRate[i] = 0;
            } else {
                failRate[i] = (double) failCount[i + 1] / totalCount;
                totalCount -= failCount[i + 1];
            }
        }

        int[] answer = new int[N];
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            int maxIndex = 0;
            double maxRate = -1;
            for (int j = 0; j < N; j++) {
                if (!visited[j] && maxRate < failRate[j]) {
                    maxIndex = j;
                    maxRate = failRate[j];
                }
            }
            answer[i] = maxIndex + 1;
            visited[maxIndex] = true;
        }

        return answer;
    }
}
