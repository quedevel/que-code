package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistance {
    public static void main(String[] args) {
        ShortestDistance shortestDistance = new ShortestDistance();
        System.out.println(shortestDistance.solution(
                new int[][]{
                        {1,0,1,1,1},
                        {1,0,1,0,1},
                        {1,0,1,1,1},
                        {1,1,1,0,1},
                        {0,0,0,0,1}
                }
        )); // 11
        System.out.println(shortestDistance.solution(
                new int[][]{
                        {1,0,1,1,1},
                        {1,0,1,0,1},
                        {1,0,1,1,1},
                        {1,1,1,0,0},
                        {0,0,0,0,1}
                }
        )); // -1
    }

    private static class Node{
        public final int x;
        public final int y;
        public final int depth;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public int solution(int[][] maps) {
        // 이동할 수 있는 경로
        final int[] dx = {0,1,0,-1};
        final int[] dy = {-1,0,1,0};

        // 방문 여부
        boolean[][] isVisited = new boolean[maps.length][maps[0].length];
        isVisited[0][0] = true;

        // 이동한 위치 Queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0,1));

        while(!queue.isEmpty()){
            Node node = queue.poll();

            // 가장빨리 최종 목적지 도달
            if (node.x == maps[node.y].length-1 && node.y == maps.length-1) return node.depth;

            // 이동 검사
            for (int d = 0; d < 4; d++) {
                int mx = node.x + dx[d];
                int my = node.y + dy[d];
                if (mx < 0 || my < 0 || my >= maps.length || mx >= maps[my].length || maps[my][mx] != 1 || isVisited[my][mx]) {
                    continue;
                }
                queue.offer(new Node(mx,my, node.depth+1));
                isVisited[my][mx] = true;
            }
        }
        return -1;
    }
}
