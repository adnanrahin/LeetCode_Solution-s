package combination_sum_III_216;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {

		System.out.println(combinationSum3(4, 24));

	}

	static int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ans = new ArrayList<>();
		backtrack(n, new ArrayList<Integer>(), ans, k, 0);
		return ans;
	}

	public static void backtrack(int n, List<Integer> list, List<List<Integer>> ans, int k, int start) {

		if (list.size() == k && n != 0)
			return;

		if (n == 0 && list.size() == k) {
			ans.add(new ArrayList<Integer>(list));
			return;
		}

		for (int j = start; j < nums.length; j++) {

			list.add(nums[j]);
			backtrack(n - nums[j], list, ans, k, j + 1);
			list.remove(list.size() - 1);

		}

		return;
	}

}
