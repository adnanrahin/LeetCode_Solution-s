package image_smoother_661;

public class Main {

	public static void main(String args[]) {

		imageSmoother(new int[][] { { 4, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } });

	}

	static int directions[][] = { { 0, 0 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
			{ 1, 1 } };

	public static int[][] imageSmoother(int[][] M) {

		if (M.length == 0)
			return new int[][] {};

		int grayScale[][] = new int[M.length][M[0].length];

		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				grayScale[i][j] = getAverage(M, i, j);
			}
		}

		return grayScale;

	}

	public static int getAverage(int grid[][], int row, int col) {

		int sum = 0;
		int count = 0;

		for (int i = 0; i < directions.length; i++) {
			int r = row + directions[i][0];
			int c = col + directions[i][1];
			if (isValid(grid, r, c)) {
				sum += grid[r][c];
				count++;
			}
		}

		return sum / count;

	}

	public static boolean isValid(int[][] grid, int row, int col) {
		return ((row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length));
	}

}
