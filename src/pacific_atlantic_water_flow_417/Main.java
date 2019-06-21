package pacific_atlantic_water_flow_417;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {

		pacificAtlantic(new int[][] { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } });

	}

	static int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static List<int[]> pacificAtlantic(int[][] matrix) {

		if (matrix == null || matrix.length == 0)
			return new ArrayList<int[]>();

		boolean atalantic[][] = new boolean[matrix.length][matrix[0].length];
		boolean pacific[][] = new boolean[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix[0].length; i++) {
			dfs(matrix, 0, i, pacific);
			dfs(matrix, matrix.length - 1, i, atalantic);
		}
		for (int i = 0; i < matrix.length; i++) {
			dfs(matrix, i, 0, pacific);
			dfs(matrix, i, matrix[0].length - 1, atalantic);
		}

		List<int[]> answer = new ArrayList<int[]>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (atalantic[i][j] && pacific[i][j]) {
					answer.add(new int[] { i, j });
				}
			}
		}

		return answer;

	}

	public static void dfs(int[][] matrix, int row, int col, boolean visited[][]) {

		if (!isValid(matrix, row, col))
			return;

		if (visited[row][col])
			return;

		visited[row][col] = true;

		for (int i = 0; i < directions.length; i++) {
			int r = row + directions[i][0];
			int c = col + directions[i][1];

			if (isValid(matrix, r, c)) {
				if (matrix[row][col] <= matrix[r][c])
					dfs(matrix, r, c, visited);
			}
		}

		return;

	}

	public static boolean isValid(int[][] matrix, int row, int col) {
		return ((row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[0].length));
	}

}
