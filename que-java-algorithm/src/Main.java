import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void solution(int n, int[][] board, int m, int[] moves){
        int cnt = 0;
        Stack<Integer> container = new Stack<>();
        for (int i = 0; i < m; i++) {
            int column = moves[i];
            for (int j = 0; j < n; j++) {
                if (board[j][column] != 0){
                    if (!container.isEmpty() && board[j][column] == container.peek()){
                        container.pop();
                        cnt += 2;
                    } else {
                        container.push(board[j][column]);
                    }
                    board[j][column] = 0;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt()-1;
        }
        solution(n, board, m, moves);
    }
}
