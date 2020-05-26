package sort_array_by_parity_II_922;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static int[] sortArrayByParityII(int[] A) {

		List<Integer> ans = new ArrayList<>();

		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 != 0) {
				ans.add(A[i]);
			}
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				ans.add(A[i]);
			}
		}

		int l = 0;
		int j = ans.size() - 1;

		while (l <= j) {
			Collections.swap(ans, l, j);
			l += 2;
			j -= 2;
		}

		for (int i = 0; i < ans.size(); i++) {
			A[i] = ans.get(i);
		}

		return A;
	}

}
