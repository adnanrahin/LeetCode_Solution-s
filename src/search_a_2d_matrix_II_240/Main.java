package search_a_2d_matrix_II_240;

public class Main {

	public static void main(String args[]) {
		int matrix_1[][] = { { 1, 3, 5, 7, }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		System.out.println(searchMatrix(matrix_1, 12));
		int matrix_2[][] = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		System.out.println(searchMatrix(matrix_2, 5));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		try {
			for(int i=0; i<matrix.length; i++) {
				if(binray_Search(matrix[i], target)) {
					return true;
				}
			}
			return false;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	private static boolean binray_Search(int arr[], int target) {

		int left = 0;
		int right = arr.length - 1;

		int mid;

		while (left <= right) {
			mid = (left + right) / 2;
			if (arr[mid] == target)
				return true;
			else if (arr[mid] < target) {
				left = mid + 1;
			} else
				right = mid - 1;
		}
		return false;
	}
}
