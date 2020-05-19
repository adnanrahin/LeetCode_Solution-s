package two_sum_1;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String args[]) {

		int nums[] = { 2, 7, 11, 15 };

		twoSum(nums, 9);

	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> myMap = new HashMap<>();
		int sol[] = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];

			if (myMap.containsKey(temp)) {
				sol[0] = i;
				sol[1] = myMap.get(temp);

				return sol;
			}

			myMap.put(nums[i], i);

		}

		return sol;

	}

}
