package number_of_enclaves_1020;

public class Main {

    public static void main(String args[]) {
        int matrix1[][] = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};

        System.out.println(numEnclaves(matrix1));

        int matrix[][] = {
                {0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0},
                {1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1}

        };
        System.out.println(numEnclaves(matrix));
    }

    public static int numEnclaves(int[][] A) {

        int row = A.length;
        int col = A[0].length;

        for (int i = 0; i < row; i++) {
            if (A[i][0] == 1)
                dfs(A, i, 0);
            if (A[i][col - 1] == 1)
                dfs(A, i, col - 1);
        }

        for (int j = 0; j < col; j++) {
            if (A[0][j] == 1)
                dfs(A, 0, j);
            if (A[row - 1][j] == 1)
                dfs(A, row - 1, j);
        }

        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    ans++;
                }
            }
        }


        return ans;
    }

    static int directions[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void dfs(int matrix[][], int row, int col) {

        if (!isValid(matrix, row, col) || matrix[row][col] == 0)
            return;

        matrix[row][col] = 0;

        for (int i = 0; i < directions.length; i++) {
            dfs(matrix, row + directions[i][0], col + directions[i][1]);
        }
        return;
    }

    public static boolean isValid(int matrix[][], int row, int col) {
        return ((row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[0].length));
    }

}
