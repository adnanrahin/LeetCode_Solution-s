package search_insert_position_35;

import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String args[]) throws NoSuchMethodException {

		int arr_1[] = { 1, 3, 5, 6 };
		int target_1 = 5;
		System.out.println(searchInsert(arr_1, target_1));
		int arr_2[] = { 1, 3, 5, 6 };
		int target_2 = 2;
		System.out.println(searchInsert(arr_2, target_2));
		int arr_3[] = { 1, 3, 5, 6 };
		int target_3 = 7;
		System.out.println(searchInsert(arr_3, target_3));
		int arr_4[] = { 1, 3, 5, 6 };
		int target_4 = 0;
		System.out.println(searchInsert(arr_4, target_4));

	}

	/*
	 * This problem can be solve by using binary_search, In purpose of JCF practice
	 * I solved this problem using SET, It has higher time and space complexity.
	 */

	public static int searchInsert(int[] nums, int target) {

		Set<Integer> set = new TreeSet<>();

		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}

		if (!set.contains(target)) {
			set.add(target);
			int l = 0;
			for (Integer i : set) {
				if (i.equals(target)) {
					return l;
				}
				l++;
			}
		} else if (set.contains(target)) {
			int l = 0;
			for (Integer i : set) {
				if (i.equals(target)) {
					return l;
				}
				l++;
			}
		}

		throw new NoSuchMethodError("NO SOLUTIONS");
	}

}
