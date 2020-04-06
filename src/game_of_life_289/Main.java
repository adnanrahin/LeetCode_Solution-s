package game_of_life_289;

import java.util.Arrays;

public class Main {

    public static void main(String args[]) {

        gameOfLife(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}});

    }

    public static void gameOfLife(int[][] board) {

        int row = board.length;
        int col = board[0].length;

        int matrix[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 0) {
                    int deadCell = checkAllNeighbor(board, i, j);
                    if (deadCell == 3)
                        matrix[i][j] = 1;
                } else {
                    int liveCell = checkAllNeighbor(board, i, j);
                    if (liveCell < 2 || liveCell > 3)
                        matrix[i][j] = 0;
                    else matrix[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = matrix[i][j];
            }
        }
    }

    public static boolean isValid(int[][] matrix, int row, int col) {
        return ((row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[0].length));
    }

    static int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

    public static int checkAllNeighbor(int[][] matrix, int row, int col) {

        int count = 0;

        for (int i = 0; i < directions.length; i++) {
            if (isValid(matrix, row + directions[i][0], col + directions[i][1]) && matrix[row + directions[i][0]][col + directions[i][1]] == 1)
                count++;
        }

        return count;

    }

}
