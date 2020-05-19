package count_square_matrix_with_all_ones_1277;

public class Main {

    public static void main(String args[]) {

        System.out.println(countSquares(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}}));

    }

    public static int countSquares(int[][] matrix) {

        int dp[][] = new int[matrix.length + 1][matrix[0].length + 1];

        int countSquares = 0;

        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;

                countSquares += dp[i][j];

            }
        }
        return countSquares;
    }

}
