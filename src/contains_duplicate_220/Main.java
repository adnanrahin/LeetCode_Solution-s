package contains_duplicate_220;

import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

	public static void main(String args[]) {
		System.out.println(containsNearbyAlmostDuplicate(new int[] { 100, 4, 6, 19, 13, 25 }, 3, 2));
		System.out.println(containsNearbyAlmostDuplicate(new int[] { 1, 3, 6, 2 }, 1, 2));
		System.out.println(containsNearbyAlmostDuplicate(new int[] { 1, 5, 9, 1, 5, 9 }, 2, 3));
		System.out.println(containsNearbyAlmostDuplicate(new int[] { 1, 2, 3, 1 }, 3, 0));
		System.out.println(containsNearbyAlmostDuplicate(new int[] { 3, 6, 0, 4 }, 2, 2));
		System.out.println(containsNearbyAlmostDuplicate(new int[] { -3, 3 }, 2, 4));
		System.out.println(containsNearbyAlmostDuplicate(new int[] { 1, 3, 1 }, 1, 1));
	}

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		if (nums.length < 2 || k < 1 || t < 0)
			return false;

		SortedSet<Long> treeset = new TreeSet<>();

		for (int i = 0; i < nums.length; i++) {

			if (!treeset.subSet((long)nums[i] - t, (long)nums[i] + t + 1).isEmpty()) {
				return true;
			}
			if (i >= k)
				treeset.remove((long)nums[i - k]);

			treeset.add((long)nums[i]);
		}

		return false;
	}

}
