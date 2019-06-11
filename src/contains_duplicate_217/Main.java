package contains_duplicate_217;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String args[]) {

	}

	public static boolean containsDuplicate(int[] nums) {

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return true;
			else set.add(nums[i]);
		}

		return false;
	}

}
