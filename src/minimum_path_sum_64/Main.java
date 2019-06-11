package minimum_path_sum_64;

public class Main {

	public static void main(String args[]) {

		int maze_0[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println("Dp Table: ");
		System.out.println("Shortest Path: " + minPathSum(maze_0));

		int maze_1[][] = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		System.out.println("Dp Table: ");
		System.out.println("Shortest Path: " + minPathSum(maze_1));

		int maze_2[][] = { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };
		System.out.println("Dp Table: ");
		System.out.println("Shortest Path: " + minPathSum(maze_2));
		int[][] maze_4 = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		System.out.println("Dp Table: ");
		System.out.println("Shortest Path: " + minPathSum(maze_4));
		
		int maze_5[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		System.out.println("Dp Table: ");
		System.out.println("Shortest Path: " + minPathSum(maze_5));
		
		int maze_6 [][] = {{1,2},{5,6},{1,1}};
		System.out.println("Dp Table: ");
		System.out.println("Shortest Path: " + minPathSum(maze_6));
	}

	public static int minPathSum(int[][] maze) {
		int n = maze.length;
		int m = maze[0].length;
		int dp[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (i == 0 && j == 0) {
					dp[i][j] = dp[i][j] + maze[i][j];
				}

				else if (j == 0 && i >= j) {
					dp[i][j] = dp[i - 1][j] + maze[i][j];
				}

				else if (i == 0 && j != 0) {
					dp[i][j] = dp[i][j - 1] + maze[i][j];
				}

				else {
					if (dp[i - 1][j] > dp[i][j - 1])
						dp[i][j] = dp[i][j - 1] + maze[i][j];
					else
						dp[i][j] = dp[i - 1][j] + maze[i][j];
				}

			}
		}
		return dp[n - 1][m - 1];
	}

}
