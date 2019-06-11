package search_a_2d_matrix_74;

public class Main {

	public static void main(String args[]) {

		int matrix_1[][] = { { 1, 3, 5, 7, }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		System.out.println(searchMatrix(matrix_1, 11));

	}

	public static boolean searchMatrix(int[][] matrix, int target) {

		try {
			int counter = -1;

			for (int i = 0; i < matrix.length; i++) {

				if (target >= matrix[i][0] && target <= matrix[i][matrix[0].length - 1]) {
					counter = i;
					break;
				}
			}

			for (int i = 0; i < matrix[counter].length; i++) {
				if (matrix[counter][i] == target) {
					return true;
				}
			}

			return false;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
