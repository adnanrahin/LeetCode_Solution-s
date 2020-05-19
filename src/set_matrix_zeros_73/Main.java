package set_matrix_zeros_73;

import java.util.ArrayList;

public class Main {

	public static void main(String args[]) {

		int mat_1[][] = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		setZeroes(mat_1);
		int mat_2[][] = { { 0 } };
		setZeroes(mat_2);
	}

	public static void setZeroes(int[][] mat_1) {
		
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < mat_1.length; i++) {
			for (int j = 0; j < mat_1[0].length; j++) {
				if (mat_1[i][j] == 0) {
					list.add(i);
					list.add(j);
				}
			}
		}

		for (int i = 0; i < list.size(); i += 2) {

			for (int j = 0; j < mat_1[0].length; j++) {
				mat_1[list.get(i)][j] = 0;
			}
			for (int j = 0; j < mat_1.length; j++) {
				mat_1[j][list.get(i + 1)] = 0;
			}
		}

		for (int i = 0; i < mat_1.length; i++) {
			for (int j = 0; j < mat_1[0].length; j++) {
				System.out.print(mat_1[i][j]);
			}
			System.out.println();
		}

	}

}
