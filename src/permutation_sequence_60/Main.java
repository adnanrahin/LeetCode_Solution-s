package permutation_sequence_60;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String args[]) {
		
		System.out.println(getPermutation(3, 5));
		System.out.println(getPermutation(8, 39532));
	}

	public static String getPermutation(int n, int k) {

		char arr[] = new char[n];

		for (int i = 0; i < n; i++) {
			arr[i] = (char) ((i + 1) + '0');
		}
		
		List<String> primary = new ArrayList<>();
		primary = permute(arr, n, primary);
		
		Collections.sort(primary);

		
		return primary.get(k-1);
	}

	private static List<String> permute(char[] a, int n, List<String> primary) {

		if (n == 1) {
			primary.add(new String(a));
		}
		for (int i = 0; i < n; i++) {
			swap(a, i, n - 1);
			permute(a, n - 1, primary);
			swap(a, i, n - 1);
		}
		return primary;
	}

	private static void swap(char[] a, int i, int j) {
		char c = a[i];
		a[i] = a[j];
		a[j] = c;
	}
}
