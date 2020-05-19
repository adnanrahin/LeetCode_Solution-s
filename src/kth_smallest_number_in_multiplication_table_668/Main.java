package kth_smallest_number_in_multiplication_table_668;

public class Main {

	public static void main(String args[]) {

		System.out.println(findKthNumber(3, 3, 5));
		System.out.println(findKthNumber(2, 3, 6));
		System.out.println(findKthNumber(9895, 28405, 100787757));
		System.out.println(findKthNumber(4, 4, 7));

	}

	public static int findKthNumber(int m, int n, int k) {

		int left = 1, right = m * n;
		while (left < right) {
			int mid = (left + right) / 2;
			if (!getcount(mid, m, n, k)) left = mid + 1;
			else right = mid;
		}
		return left;
	}

	private static boolean getcount(int mid, int m, int n, int k) {

		int counter = 0;
		for (int i = 1; i <= m; i++) {
			counter += Math.min(mid / i, n);
		}
		return counter >= k;

	}

}
