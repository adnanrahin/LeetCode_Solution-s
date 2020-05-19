package find_all_duplicates_in_an_array_442;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String args[]) {
		System.out.println(findDuplicates(new int[] {}));
	}

	public static List<Integer> findDuplicates(int[] nums) {

		Set<Integer> set = new HashSet<Integer>();

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {

			if (set.contains(nums[i])) {
				list.add(nums[i]);
			} else
				set.add(nums[i]);

		}

		return list;
	}

}
