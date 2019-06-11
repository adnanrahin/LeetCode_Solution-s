package array_partition_561;

import java.util.Arrays;

public class Main {

	public static void main(String args[]) {

		System.out.println(arrayPairSum(new int[] { 1, 4, 3, 2 }));
		System.out.println(arrayPairSum(new int[] { 1, 2, 3, 4, 5, 5 }));

	}

	public static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i += 2)
			sum += nums[i];

		return sum;
	}

}
