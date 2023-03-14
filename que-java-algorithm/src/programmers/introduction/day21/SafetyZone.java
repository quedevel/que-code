package programmers.introduction.day21;

public class SafetyZone {
    public static void main(String[] args) {
        SafetyZone safetyZone = new SafetyZone();
        System.out.println(safetyZone.solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}}));
        System.out.println(safetyZone.solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}}));
        System.out.println(safetyZone.solution(new int[][]{{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}}));
    }
    public int solution(int[][] board) {
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1){
                    if (i-1 >= 0){
                        if (j-1 >= 0){
                            board[i-1][j-1] = board[i-1][j-1] == 1? 1 : 2;
                        }
                        if (j+1 < board[i].length){
                            board[i-1][j+1] = board[i-1][j+1] == 1? 1 : 2;
                        }
                        board[i-1][j] = board[i-1][j] == 1? 1 : 2;
                    }
                    if (i+1 < board.length){
                        if (j-1 >= 0){
                            board[i+1][j-1] = board[i+1][j-1] == 1? 1 : 2;
                        }
                        if (j+1 < board[i].length){
                            board[i+1][j+1] = board[i+1][j+1] == 1? 1 : 2;
                        }
                        board[i+1][j] = board[i+1][j] == 1? 1 : 2;
                    }
                    if (j-1 >= 0){
                        board[i][j-1] = board[i][j-1] == 1? 1 : 2;
                    }
                    if (j+1 < board[i].length){
                        board[i][j+1] = board[i][j+1] == 1? 1 : 2;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) answer++;
            }
        }
        return answer;
    }
}
