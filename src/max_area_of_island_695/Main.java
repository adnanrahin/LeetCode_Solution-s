package max_area_of_island_695;

public class Main {

	public static void main(String args[]) {

		System.out.println(maxAreaOfIsland(
				new int[][] { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
						{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
						{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } }));

		System.out.println(maxAreaOfIsland(new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } }));

	}

	static int directions[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static int maxAreaOfIsland(int[][] grid) {

		int maximumarea = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					maximumarea = Math.max(maximumarea, dfs(grid, i, j));
				}
			}
		}

		return maximumarea;

	}

	public static int dfs(int grid[][], int row, int col) {

		if (!isValid(grid, row, col) || grid[row][col] == 0) {
			return 0;
		}

		int maxArea = 1;

		grid[row][col] = 0;

		for (int i = 0; i < directions.length; i++) {
			maxArea += dfs(grid, row + directions[i][0], col + directions[i][1]);
		}

		return maxArea;

	}

	public static boolean isValid(int grid[][], int row, int col) {
		return ((row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length));
	}

}
