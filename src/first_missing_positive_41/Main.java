package first_missing_positive_41;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String args[]) {

		System.out.println(firstMissingPositive(new int[] { 1, 2, 0 }));
		System.out.println(firstMissingPositive(new int[] { 1, 2, 3, 4, 5, 6 }));
		System.out.println(firstMissingPositive(new int[] { 4, 3, -1, 1 }));
		System.out.println(firstMissingPositive(new int[] { -5 }));
		System.out.println(firstMissingPositive(new int[] { 2, 1 }));
		System.out.println(firstMissingPositive(new int[] { 1, 2, 3, 10, 2147483647, 9 }));
	}

	public static int firstMissingPositive(int[] nums) {
		if (nums.length == 0)
			return 1;
		Set<Integer> set = new HashSet<Integer>();

		int max = nums[0];

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 0) {
				set.add(nums[i]);
				max = Math.max(max, nums[i]);
			}
		}

		System.out.println(set);

		for (int i = 1; i <= max; i++) {
			if (!set.contains(i))
				return i;
		}
		return max > 0 ? max + 1 : 1;

	}
}
