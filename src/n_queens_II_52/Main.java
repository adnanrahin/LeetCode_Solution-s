package n_queens_II_52;

public class Main {

    public static void main(String args[]) {

        System.out.println(totalNQueens(4));

    }

    public static int totalNQueens(int n) {
        int[][] board = new int[n][n];

        return backTrack(board, n, 0);
    }

    public static int backTrack(int board[][], int queens, int col) {

        if (col == queens) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < queens; i++) {
            if (isSafe(i, col, board)) {
                board[i][col] = 1;
                count += backTrack(board, queens, col + 1);
                board[i][col] = 0;
            }
        }
        return count;
    }

    public static boolean isSafe(int row, int col, int board[][]) {

        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 1)
                return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (int i = row, j = col; j >= 0 && i < board.length; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

}
