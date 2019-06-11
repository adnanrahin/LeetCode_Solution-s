package squares_of_a_sorted_array_977;

import java.util.Arrays;

public class Main {

	public static void main(String args[]) {

	}

	public static int[] sortedSquares(int[] A) {

		int arr[] = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			arr[i] = A[i] * A[i];
		}
		Arrays.sort(arr);
		return arr;
	}
}
