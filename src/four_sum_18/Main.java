package four_sum_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String args[]) {
		System.out.println(fourSum(new int[] { -3, -2, -1, 0, 0, 1, 2, 3 }, 0));
		// System.out.println(fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));

	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {

		if (nums.length == 0)
			return new ArrayList<List<Integer>>();

		Arrays.sort(nums);

		List<List<Integer>> answer = new ArrayList<>();

		List<Integer> local = new ArrayList<Integer>();

		for (int i = 0; i < nums.length - 3; i++) {

			int t1 = target - nums[i];

			for (int j = i + 1; j < nums.length - 2; j++) {

				int t2 = t1 - nums[j];

				for (int l = j + 1; l < nums.length - 1; l++) {

					int t3 = t2 - nums[l];

					for (int k = l + 1; k < nums.length; k++) {

						local = new ArrayList<Integer>();

						if (t3 - nums[k] == 0) {
							local.add(nums[i]);
							local.add(nums[j]);
							local.add(nums[l]);
							local.add(nums[k]);
							if (!answer.contains(local))
								answer.add(local);
						}

					}

				}

			}

		}

		return answer;

	}

}
