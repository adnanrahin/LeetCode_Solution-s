package zero_one_matrix_542;

public class Main {

    public static void main(String args[]) {

        int matrix1[][] = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int matrix2[][] = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0)
            return matrix;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && !HasZeroNeighbor(i, j, matrix))
                    matrix[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1)
                    Dfs(matrix, i, j, 1);
            }
        }

        return matrix;
    }

    public boolean HasZeroNeighbor(int i, int j, int[][] matrix) {
        if (i - 1 >= 0 && matrix[i - 1][j] == 0)
            return true;
        if (i + 1 < matrix.length && matrix[i + 1][j] == 0)
            return true;
        if (j - 1 >= 0 && matrix[i][j - 1] == 0)
            return true;
        if (j + 1 < matrix[0].length && matrix[i][j + 1] == 0)
            return true;

        return false;
    }

    public void Dfs(int[][] matrix, int row, int col, int val) {
        if (!isValid(matrix, row, col) || matrix[row][col] < val)
            return;

        matrix[row][col] = val;

        Dfs(matrix, row + 1, col, matrix[row][col] + 1);
        Dfs(matrix, row - 1, col, matrix[row][col] + 1);
        Dfs(matrix, row, col - 1, matrix[row][col] + 1);
        Dfs(matrix, row, col + 1, matrix[row][col] + 1);
    }

    public static boolean isValid(int[][] matrix, int row, int col) {
        return ((row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[0].length));
    }
}
