package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class ItemPicker {
    public static void main(String[] args) {
        ItemPicker itemPicker = new ItemPicker();
        System.out.println(itemPicker.solution(
                new int[][]{
                        {1,1,7,4},
                        {3,2,5,5},
                        {4,3,6,9},
                        {2,6,8,8}
                },
                1,3,7,8
                )
        );
        System.out.println(itemPicker.solution(
                new int[][]{
                        {1,1,8,4},
                        {2,2,4,9},
                        {3,6,9,8},
                        {6,3,7,7}
                },
                9,7,6,1
                )
        );
        System.out.println(itemPicker.solution(
                new int[][]{
                        {1,1,5,7}
                },
                1,1,4,7
                )
        );
        System.out.println(itemPicker.solution(
                new int[][]{
                        {2,1,7,5},
                        {6,4,10,10}
                },
                3,1,7,10
                )
        );
        System.out.println(itemPicker.solution(
                new int[][]{
                        {2,2,5,5},
                        {1,3,6,4},
                        {3,1,4,6}
                },
                1,4,6,3
                )
        );
    }

    static final int[] dx = new int[]{-1, 1, 0, 0};
    static final int[] dy = new int[]{0, 0, -1, 1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        Boolean[][] border = new Boolean[102][102];

        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        for (int[] arr : rectangle) {
            for (int j = 0; j < 4; j++) arr[j] *= 2;
            for (int x = arr[0]; x <= arr[2]; x++) {
                for (int y = arr[1]; y <= arr[3]; y++) {
                    border[x][y] = (x == arr[0] || x == arr[2] ||
                            y == arr[1] || y == arr[3]) && border[x][y] != Boolean.FALSE;
                }
            }
        }


        Queue<State> queue = new LinkedList<>();
        border[characterX][characterY] = false;
        queue.offer(new State(characterX, characterY, 0));

        while(!queue.isEmpty()){
            State state = queue.poll();

            if (state.x == itemX && state.y == itemY){
                return state.depth/2;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = state.x + dx[i];
                int ny = state.y + dy[i];
                if(nx < 2 || ny < 2 || nx > 100 || ny > 100) continue;
                if(border[nx][ny] != Boolean.TRUE) continue;
                border[nx][ny] = false;
                queue.offer(new State(nx,ny, state.depth+1));
            }

        }
        return -1;
    }
    private static class State {
        public final int x;
        public final int y;
        public final int depth;

        public State(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
