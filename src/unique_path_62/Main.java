package unique_path_62;

public class Main {

	public static void main(String args[]) {

		System.out.println(total_path(7, 3));

	}

	public static int total_path(int m, int n) {

		int[][] maze = new int[m][n];

		for (int i = 0; i < m; i++)
			maze[i][0] = 1;
		for (int j = 1; j < n; j++)
			maze[0][j] = 1;

		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				maze[i][j] = maze[i - 1][j] + maze[i][j - 1];

		return maze[m - 1][n - 1];
	}

}
