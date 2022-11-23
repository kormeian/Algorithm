import java.util.*;

public class Main {
    static int[] answer = new int[2];
    public static void fold(int x, int y, int size, int[][] board) {
        if(isFold(x, y, size, board)){
            if(board[x][y] == 0) answer[0]++;
            else answer[1]++;
            return ;
        }
        fold(x, y, size/2, board);
        fold(x + size / 2, y, size/2, board);
        fold(x, y + size / 2, size/2, board);
        fold(x + size / 2, y + size / 2, size/2, board);

    }
    public static boolean isFold(int x, int y, int size, int[][] board){
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] != board[x][y]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[][] board = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                board[i][j] = in.nextInt();
            }
        }
        fold(0,0, board.length, board);
        for (int result : answer){
            System.out.println(result);
        }
    }
}
