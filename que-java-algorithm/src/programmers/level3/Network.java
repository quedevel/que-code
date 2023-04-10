package programmers.level3;

import java.util.Stack;

public class Network {
    public static void main(String[] args) {
        Network network = new Network();
        System.out.println(network.solution(
                3,
                new int[][]{{1,1,0},{1,1,0},{0,0,1}}
        )); // 2
        System.out.println(network.solution(
                3,
                new int[][]{{1,1,0},{1,1,1},{0,1,1}}
        )); // 1
    }
    // 1 1 0  (0,1)
    // 1 1 0  (1,0)
    // 0 0 1

    // 1 0 1  (0,1)
    // 0 1 1  (1,0) (1,2)
    // 1 1 1  (2,1)
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (isVisited[i]) continue;
            dfs(i, computers, isVisited);
            answer++;
        }

        return answer;
    }

    private static void dfs(int n, int[][] computers, boolean[] isVisited){
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        while(!stack.isEmpty()){
            int standard = stack.pop();
            if (!isVisited[standard]){
                isVisited[standard] = true;
                for (int next = 0; next < computers[standard].length; next++) {
                    if (computers[standard][next] == 1){
                        stack.push(next);
                    }
                }
            }
        }
    }
}
