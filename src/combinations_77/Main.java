package combinations_77;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {

		System.out.println(combine(4, 2));

	}

	public static List<List<Integer>> combine(int n, int k) {

		int nums[] = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}

		List<List<Integer>> ans = new ArrayList<>();

		long size = (long) Math.pow(2, nums.length);

		for (int i = 0; i < size; i++) {

			List<Integer> primary = new ArrayList<>();
			for (int j = 0; j < nums.length; j++) {

				if ((i & (1 << j)) > 0)
					primary.add(nums[j]);
			}
			
			if (primary.size() == k)
				ans.add(primary);
			
		}

		return ans;

	}

}
