package making_a_large_island_827;

public class Main {

	public static void main(String args[]) {

		System.out.println(largestIsland(new int[][] { { 1, 1, 1, 0, 0 }, { 0, 0, 1, 0, 0 }, { 1, 0, 0, 1, 0 },
				{ 1, 0, 1, 0, 0 }, { 0, 0, 1, 1, 0 } }));

		System.out.println(largestIsland(new int[][] { { 1, 1 }, { 1, 0 } }));

	}

	static int directions[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static int largestIsland(int[][] grid) {

		if (grid.length == 0)
			return 0;

		boolean visited[][] = new boolean[grid.length][grid[0].length];

		int onecounter = 0;

		int largestIsalnd = 0;

		for (int i = 0; i < grid.length; i++) {

			for (int j = 0; j < grid[0].length; j++) {
				visited = new boolean[grid.length][grid[0].length];
				if (grid[i][j] == 0) {
					grid[i][j] = 1;
					largestIsalnd = Math.max(largestIsalnd, dfs(grid, i, j, visited));
					grid[i][j] = 0;
				} else
					onecounter++;
			}
		}

		return grid.length * grid[0].length == onecounter ? onecounter : largestIsalnd;
	}

	public static boolean isValid(int grid[][], int row, int col) {
		return ((row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length));
	}

	public static int dfs(int grid[][], int row, int col, boolean visited[][]) {

		if (!isValid(grid, row, col) || visited[row][col] || grid[row][col] == 0)
			return 0;

		visited[row][col] = true;

		int count = 1;

		for (int i = 0; i < directions.length; i++) {
			count += dfs(grid, row + directions[i][0], col + directions[i][1], visited);
		}

		return count;

	}

}
