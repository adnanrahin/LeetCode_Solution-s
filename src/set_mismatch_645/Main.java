package set_mismatch_645;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String args[]) {

	}

	public static int[] findErrorNums(int[] nums) {

		if(nums.length == 0)
			return null;
		
		Set<Integer> set = new HashSet<Integer>();

		int val = 0;

		for (int i = 0; i < nums.length; i++)
			if (!set.add(nums[i]))
				val = nums[i];

		int val2 = 0;

		for (int i = 1; i <= nums.length; i++) {
			if (!set.contains(i))
				val2 = i;
		}

		return new int[] { val, val2 };
	}

}
