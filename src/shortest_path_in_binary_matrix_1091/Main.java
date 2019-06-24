package shortest_path_in_binary_matrix_1091;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String args[]) {
		System.out.println(shortestPathBinaryMatrix(new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } }));
		System.out.println(shortestPathBinaryMatrix(
				new int[][] { { 0, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 1, 0, 0 }, { 1, 1, 1, 0 } }));
	}

	static int directions[][] = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
			{ 1, 1 } };

	public static int shortestPathBinaryMatrix(int[][] grid) {

		if (grid.length == 0)
			return -1;

		if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1)
			return -1;

		boolean visited[][] = new boolean[grid.length][grid[0].length];

		return shortestPath(grid, 0, 0, visited);
	}

	public static int shortestPath(int grid[][], int row, int col, boolean visited[][]) {

		visited[row][col] = true;

		Queue<int[]> queue = new LinkedList<int[]>();

		queue.add(new int[] { row, col, 0 });

		while (!queue.isEmpty()) {

			int temparr[] = queue.poll();

			if (temparr[0] == grid.length - 1 && temparr[1] == grid[0].length - 1)
				return temparr[2] + 1;

			for (int i = 0; i < directions.length; i++) {
				int r1 = temparr[0] + directions[i][0];
				int c1 = temparr[1] + directions[i][1];

				if (isValid(grid, r1, c1) && !visited[r1][c1] && grid[r1][c1] == 0) {
					visited[r1][c1] = true;
					queue.add(new int[] { r1, c1, temparr[2] + 1 });
				}

			}

		}

		return -1;

	}

	public static boolean isValid(int grid[][], int row, int col) {
		return ((row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length));
	}

}
