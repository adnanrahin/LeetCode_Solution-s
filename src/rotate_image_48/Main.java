package rotate_image_48;

public class Main {

	public static void main(String args[]) {

		rotate(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } });
		rotate(new int[][] { { 1, 2, 3 }, { 5, 6, 7 }, { 9, 10, 11 } });
		rotate(new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } });
	}

	public static void rotate(int[][] matrix) {

		int row = matrix.length;
		int col = matrix[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = i; j < col; j++) {

				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;

			}

		}
		
		int left = 0;
		int right = matrix.length - 1;

		while (left < right) {

			for (int i = 0; i < row; i++) {
				int temp = matrix[i][left];
				matrix[i][left] = matrix[i][right];
				matrix[i][right] = temp;
			}
			left++;
			right--;
		}

	}
}
