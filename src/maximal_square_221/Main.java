package maximal_square_221;

public class Main {

    public static void main(String args[]) {

    }

    public int maximalSquare(char[][] matrix) {

        if (matrix.length == 0)
            return 0;

        int dp[][] = new int[matrix.length + 1][matrix[0].length + 1];

        int area = 0;

        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {

                if (matrix[i - 1][j - 1] == '0')
                    dp[i][j] = 0;
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;

                area = Math.max(area, dp[i][j]);

            }
        }

        return area * area;
    }

}
