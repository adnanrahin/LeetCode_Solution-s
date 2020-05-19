package missing_numbers_268;

import java.util.Arrays;

public class Main {

	public static void main(String args[]) {
		System.out.println(missingNumber(new int[] { 3, 0, 1 }));
		System.out.println(missingNumber(new int[] { 0 }));
	}

	public static int missingNumber(int[] nums) {
		if (nums.length == 1 && nums[0] == 0)
			return 1;
		int n = nums.length;
		int sum_of_n = ((n * n) + n) / 2;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			if (sum_of_n - i == sum) {
				return i;
			}
		}

		return nums.length;
	}

	public static int missingNumber_sort(int[] nums) {
		if (nums.length == 1 && nums[0] == 0)
			return 1;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {

			if (nums[i] != i)
				return i;

		}
		return nums.length + 1;
	}

}
