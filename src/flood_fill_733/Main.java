package flood_fill_733;

public class Main {

	public static void main(String args[]) {

		floodFill(new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }, 1, 1, 2);
		floodFill(new int[][] { { 0, 0, 0 }, { 0, 0, 0 } }, 0, 0, 2);

	}

	static int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		int pixel = image[sr][sc];

		dfs(image, sr, sc, newColor, pixel);

		return image;
	}

	public static void dfs(int[][] image, int row, int col, int newColor, int pixel) {

		if (!isValid(image, row, col))
			return;

		if (image[row][col] != pixel || image[row][col] == newColor)
			return;

		image[row][col] = newColor;

		for (int i = 0; i < directions.length; i++) {
			dfs(image, row + directions[i][0], col + directions[i][1], newColor, pixel);
		}
		return;

	}

	public static boolean isValid(int[][] image, int row, int col) {
		return ((row >= 0 && row < image.length) && (col >= 0 && col < image[0].length));
	}

}
