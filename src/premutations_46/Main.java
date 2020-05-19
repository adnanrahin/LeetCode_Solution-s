package premutations_46;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {

		System.out.println(permute(new int[] { 1, 2, 3 }));
		System.out.println(permute(new int [] {1}));
	}


	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> primary = new ArrayList<>();

		return permutation(nums, 0, nums.length - 1,primary);
	}

	private static List<List<Integer>> permutation(int nums[], int start, int end, List<List<Integer>> primary) {

		if (start == end) {
			List<Integer> list = new ArrayList<>();
			
			for( int i = 0; i < nums.length; i++) {
				list.add(nums[i]);
			}
			
			primary.add(list);
		} else {
			for (int i = start; i <= end; i++) {
				int temp = nums[i];
				nums[i] = nums[start];
				nums[start] = temp;

				permutation(nums, start + 1, end, primary);

				temp = nums[i];
				nums[i] = nums[start];
				nums[start] = temp;

			}
		}
		return primary;
	}
	
}
