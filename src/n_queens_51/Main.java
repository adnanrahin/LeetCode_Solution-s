package n_queens_51;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        System.out.println(solveNQueens(4));

    }

    public static List<List<String>> solution;

    public static List<List<String>> solveNQueens(int n) {

        solution = new ArrayList<>();
        int[][] board = new int[n][n];
        backTrack(board, 0, n);


        return solution;
    }

    public static boolean backTrack(int board[][], int col, int queens) {

        if (queens == col) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < board.length; j++) {
                String str = new String();
                for (int k = 0; k < board[0].length; k++) {
                    if (board[j][k] == 0)
                        str += ".";
                    else
                        str += "Q";
                }
                list.add(str);
            }
            solution.add(list);
            return true;
        }
        boolean temp = false;
        for (int i = 0; i < queens; i++) {

            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                temp = backTrack(board, col + 1, queens) || temp;
                board[i][col] = 0;
            }

        }
        return temp;
    }


    public static boolean isSafe(int[][] board, int row, int col) {

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
