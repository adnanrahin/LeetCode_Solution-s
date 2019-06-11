package spiral_matrix_54;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {

		System.out.println(spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
		System.out.println(spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));
		System.out.println(spiralOrder(new int[][] { { 3 }, { 2 } }));
		System.out.println(spiralOrder(new int[][] { { 1, 2, 3 } }));
		System.out.println(spiralOrder(new int[][] { { 7 }, { 9 }, { 6 } }));
		System.out.println(spiralOrder(new int[][] { { 1, 2 }, { 3, 4 } }));
		System.out.println(
				spiralOrder(new int[][] { { 2, 3, 4 }, { 5, 6, 7 }, { 8, 9, 10 }, { 11, 12, 13 }, { 14, 15, 16 } }));
	}

	public static List<Integer> spiralOrder(int[][] mat) {

		List<Integer> list = new ArrayList<>();

		try {
			int row = mat.length;
			int col = mat[0].length;
			if (row == 1) {
				for (int i = 0; i < col; i++) {
					list.add(mat[0][i]);
				}
				return list;
			}

			if (col == 1) {
				for (int i = 0; i < row; i++) {
					list.add(mat[i][0]);
				}
				return list;
			}

			int l = 0;

			for (int i = 0; i < row; i++) {

				int j, k, m, o;

				for (j = i; j < col - i - 1; j++) {
					if (l == row * col)
						break;
					list.add(mat[i][j]);
					l++;
				}

				for (k = i; k < row - i - 1; k++) {
					if (l == row * col)
						break;
					list.add(mat[k][j]);
					l++;
				}

				for (m = col - i - 1; m > i; m--) {
					if (l == row * col)
						break;
					list.add(mat[k][m]);
					l++;
				}

				for (o = row - i - 1; o > i; o--) {
					if (l == row * col)
						break;
					list.add(mat[o][m]);
					l++;
				}

			}

			if (row == col && row * col % 2 != 0) {
				list.add(mat[row / 2][col / 2]);
			}

		} catch (Exception e) {
			return list;
		}
		return list;
	}

}
