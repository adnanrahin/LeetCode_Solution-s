package subsets_78;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {

		List<List<Integer>> list = subsets(new int[] { 1, 2, 3 });

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	public static List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> ans = new ArrayList<>();

		long size = (long) Math.pow(2, nums.length);

		for (int i = 0; i < size; i++) {
			List<Integer> primary = new ArrayList<>();
			for (int j = 0; j < nums.length; j++) {

				if ((i & (1 << j)) > 0) {
					primary.add(nums[j]);
				}

			}

			ans.add(primary);

		}

		return ans;
	}

}
