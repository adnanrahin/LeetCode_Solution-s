package number_of_island_200;

public class Main {

	public static void main(String args[]) {

		System.out.println(numIslands(new char[][] { { '0', '1', '0', '1', '0' }, { '0', '0', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' }, { '0', '1', '1', '0', '0' }, { '1', '0', '1', '0', '1' } }));

	}

	public static int numIslands(char[][] grid) {

		int numberOfIsland = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j);
					numberOfIsland++;
				}
			}
		}

		return numberOfIsland;

	}

	public static void dfs(char[][] grid, int row, int col) {

		if (!isValid(grid, row, col))
			return;

		if (grid[row][col] == '0')
			return;

		grid[row][col] = '0';

		dfs(grid, row, col - 1);
		dfs(grid, row, col + 1);
		dfs(grid, row - 1, col);
		dfs(grid, row + 1, col);

	}

	public static boolean isValid(char[][] grid, int row, int col) {

		if ((row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length))
			return true;

		return false;
	}

}
