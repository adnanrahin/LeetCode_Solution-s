package permutations_II_47;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String args[]) {

		System.out.println(permuteUnique(new int[] { 2, 1, 1 }));
		System.out.println(permuteUnique(new int[] { 1 }));
		System.out.println(permuteUnique(new int[] { 1, 1, 2 }));
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		
		List<List<Integer>> primary = new ArrayList<>();

		Set<List<Integer>> set = new HashSet<>();

		return permutation(nums, 0, nums.length - 1, primary, set);
	}

	private static List<List<Integer>> permutation(int nums[], int start, int end, List<List<Integer>> primary,
			Set<List<Integer>> set) {

		if (start == end) {
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < nums.length; i++) {
				list.add(nums[i]);
			}
			if (!set.contains(list)) {
				set.add(list);
				primary.add(list);
			}
		} else {
			for (int i = start; i <= end; i++) {
				swap(nums, i, start);
				permutation(nums, start + 1, end, primary, set);
				swap(nums, i, start);
			}
		}
		return primary;
	}

	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
