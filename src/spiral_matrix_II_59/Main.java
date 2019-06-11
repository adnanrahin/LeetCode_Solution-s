package spiral_matrix_II_59;

public class Main {

	public static void main(String args[]) {

		generateMatrix(1);
		generateMatrix(2);
		generateMatrix(3);
		generateMatrix(4);
		generateMatrix(5);
		generateMatrix(9);
		generateMatrix(6);
		generateMatrix(7);
		generateMatrix(8);
		generateMatrix(9);
		generateMatrix(10);

	}

	public static int[][] generateMatrix(int n) {

		int l = 1;
		int mat[][] = new int[n][n];

		for (int i = 0; i < n/2; i++) {

			int j, k, m, o;

			for (j = i; j < n - i - 1; j++) {
				mat[i][j] = l++;
			}

			for (k = i; k < n - i - 1; k++) {
				mat[k][j] = l++;
			}

			for (m = n - i - 1; m > i; m--) {
				mat[k][m] = l++;
			}

			for (o = n - i - 1; o > i; o--) {
				mat[o][m] = l++;
			}
		}

		if (n % 2 != 0)
			mat[n / 2][n / 2] = n * n;

		return mat;

	}

}
