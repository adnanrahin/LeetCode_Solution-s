package permutations_60;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {
		System.out.println(getPermutation(3, 3));
		System.out.println(getPermutation(8, 39532));
	}

	public static String getPermutation(int n, int k) {

		List<Integer> list = new ArrayList<Integer>();
		StringBuffer stringBuffer = new StringBuffer();
		int[] fact = new int[n + 1];

		fact[0] = 1;

		for (int i = 1; i <= n; i++) {
			fact[i] = fact[i - 1] * i;
			list.add(i);
		}

		k--;
		
		for (int i = 1; i <= n; i++) {

			int idx = k / fact[n - i];
			stringBuffer.append(String.valueOf(list.get(idx)));
			list.remove(idx);
			k = k - (idx * fact[n - i]);

		}

		return stringBuffer.toString();

	}

}
