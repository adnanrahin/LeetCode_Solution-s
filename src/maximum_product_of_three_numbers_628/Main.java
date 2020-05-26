package maximum_product_of_three_numbers_628;

import java.util.Arrays;

public class Main {

	public static void main(String args[]) {

		System.out.println(maximumProduct(new int[] { 1, 4, 4, 5 }));
		System.out.println(maximumProduct(new int[] { 5, 3, 3, 2, 1 }));
	}

	public static int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		return Math.max((nums[0] * nums[1] * nums[nums.length - 1]),
				(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]));
	}

}
