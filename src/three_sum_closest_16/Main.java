package three_sum_closest_16;

import java.util.Arrays;

public class Main {

	public static void main(String args[]) {

		System.out.println(threeSumClosest(new int[] { 0, 2, 1, -3 }, 1)); // 0
		System.out.println(threeSumClosest(new int[] { 1, 1, 1, 0 }, -100)); // 2
		System.out.println(threeSumClosest(new int[] { 1, 1, 1, 1 }, 3)); // 3

	}

	public static int threeSumClosest(int[] nums, int target) {

		int minimumsum = Integer.MAX_VALUE;
		Arrays.sort(nums);
		int closeval = 0;
		for (int i = 0; i < nums.length - 2; i++) {

			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {

				if (Math.abs(nums[i] + nums[left] + nums[right] - target) < minimumsum) {
					closeval = nums[i] + nums[left] + nums[right];
					minimumsum = Math.abs(nums[i] + nums[left] + nums[right] - target);
				}

				if (nums[i] + nums[left] + nums[right] > target)
					right--;
				else if (nums[i] + nums[left] + nums[right] < target)
					left++;
				else
					return nums[i] + nums[left] + nums[right];

			}

		}

		return closeval;
	}

}
