package soduku_solver_37;

public class Main {


    public static void main(String args[]) {
        char board[][] = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(char[][] board) {

        backtrack(board);

    }

    public static boolean backtrack(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '.') {
                    for (int l = 1; l <= 9; l++) {
                        if (!isInCol(j, board, (char) (l + '0')) && !isInRow(i, board, (char) (l + '0')) && !searchGrid(i, j, board, (char) (l + '0'))) {
                            board[i][j] = (char) (l + '0');
                            if (backtrack(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }

            }
        }
        return true;
    }

    public static boolean isInCol(int col, char[][] board, char a) {

        for (int i = 0; i < 9; i++) {
            if (a == board[i][col])
                return true;
        }
        return false;
    }

    public static boolean isInRow(int row, char[][] board, char a) {
        for (int i = 0; i < 9; i++) {
            if (a == board[row][i])
                return true;
        }
        return false;
    }


    public static boolean searchGrid(int row, int col, char[][] board, char a) {
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if (board[i][j] == a) {
                    return true;
                }
            }
        }
        return false;
    }
}
