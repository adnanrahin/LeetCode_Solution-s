package single_number_II_137;

import java.util.Arrays;

public class Main {

	public static void main(String args[]) {
		System.out.println(singleNumber(new int[] { 0, 1, 0, 1, 0, 1, 99 }));
		System.out.println(singleNumber(new int[] { 0, 1, 99, 1, 99, 1, 99 }));
		System.out.println(
				singleNumber(new int[] { -19, -46, -19, -46, -9, -9, -19, 17, 17, 17, -13, -13, -9, -13, -46, -28 }));
	}

	public static int singleNumber(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length - 1; i++) {
			if (i == 0 && nums[i] != nums[i + 1])
				return nums[i];
			else if (nums[i] != nums[i + 1] && i < nums.length - 2) {
				if (nums[i + 1] != nums[i + 2])
					return nums[i + 1];
			} else if (nums[i] != nums[i + 1] && i == nums.length - 2)
				return nums[i + 1];

		}
		throw new NoSuchMethodError("");
	}

}
