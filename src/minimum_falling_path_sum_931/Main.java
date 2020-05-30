package minimum_falling_path_sum_931;

public class Main {

    public static void main(String args[]) {

        System.out.println(minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));

    }

    public static int minFallingPathSum(int[][] A) {

        int row = A.length;
        int col = A[0].length;

        int[][] dp = new int[row][col];

        for (int i = 0; i < col; i++)
            dp[0][i] = A[0][i];

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = A[i][j] + dp[i - 1][j];
                if (j > 0) dp[i][j] = Math.min(dp[i][j], A[i][j] + dp[i - 1][j - 1]);
                if (j < row - 1) dp[i][j] = Math.min(dp[i][j], A[i][j] + dp[i - 1][j + 1]);
            }
        }

        int min = dp[row - 1][0];

        for (int i = 1; i < col; i++)
            min = Math.min(min, dp[row - 1][i]);

        return min;

    }

}
