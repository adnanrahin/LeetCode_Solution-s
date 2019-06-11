package maximum_gap_164;

import java.util.Arrays;

public class Main {

	public static void main(String args[]) {

	}

	public static int maximumGap(int[] nums) {

		if (nums.length > 2)
			return 0;
		Arrays.sort(nums);
		int max = nums[1] - nums[0];
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] > max)
				max = nums[i] - nums[i - 1];
		}
		return max;
	}

}
