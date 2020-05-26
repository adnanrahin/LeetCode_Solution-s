package coloring_a_boarder_1034;

public class Main {

	public static void main(String args[]) {

		System.out.println(
				colorBorder(new int[][] { { 2, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } }, 0, 0, 3));

		System.out.println(colorBorder(new int[][] { { 1, 2, 2 }, { 2, 3, 3 } }, 0, 1, 3));
		System.out.println(colorBorder(new int[][] { { 1, 1 }, { 1, 2 } }, 0, 0, 3));

		System.out.println(
				colorBorder(new int[][] { { 1, 2, 1, 2, 1, 2 }, { 2, 2, 2, 2, 1, 2 }, { 1, 2, 2, 2, 1, 2 } }, 1, 3, 1));
		System.out.println(colorBorder(new int[][] { { 2, 2, 2 }, { 2, 2, 2 }, { 2, 2, 2 } }, 0, 1, 3));
		/*
		 *@ [[1,2,1,2,1,2], [2,2,2,2,1,2], [1,2,2,2,1,2]] 
		 * [[1,1,1,1,1,2], [1,2,1,1,1,2], [1,1,1,1,1,2]]
		 */

	}

	static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
		int val = grid[r0][c0];
		dfs(grid, r0, c0, val);

		for (int i = 1; i < grid.length - 1; i++) {
			for (int j = 1; j < grid[0].length - 1; j++) {
				if (grid[i][j] == -1 && (grid[i - 1][j] == -1 || grid[i - 1][j] == -2) && grid[i + 1][j] == -1
						&& (grid[i][j - 1] == -1 || grid[i][j - 1] == -2) && grid[i][j + 1] == -1)
					grid[i][j] = -2;
			}
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == -1)
					grid[i][j] = color;
				if (grid[i][j] == -2)
					grid[i][j] = val;
			}
		}

		return grid;
	}

	public static boolean isValid(int[][] grid, int row, int col) {
		return ((row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length));
	}

	public static void dfs(int grid[][], int row, int col, int val) {

		if (!isValid(grid, row, col) || grid[row][col] != val)
			return;
		grid[row][col] = -1;
		for (int i = 0; i < directions.length; i++) {
			dfs(grid, row + directions[i][0], col + directions[i][1], val);
		}
		return;

	}
}
