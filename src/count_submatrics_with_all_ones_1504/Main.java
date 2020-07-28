package count_submatrics_with_all_ones_1504;

public class Main {
    public static void main(String[] args) {

        System.out.println(numSubmat(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 1}, {1, 1, 1, 0}}));

    }

    public static int numSubmat(int[][] mat) {

        int[][] dp = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat[0].length; i++)
            dp[0][i] = mat[0][i];
        for (int i = 0; i < mat.length; i++)
            dp[i][0] = mat[i][0];


        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                dp[i][j] = mat[i][j] + dp[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1];
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[mat.length - 1][mat[0].length - 1];

    }

}
