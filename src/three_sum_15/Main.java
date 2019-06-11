package three_sum_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String args[]) {

		System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
		System.out.println(threeSum(new int[] { -1, 0, 1 }));
		System.out.println(threeSum(new int[] { 1, 0, -1 }));
		System.out.println(threeSum(new int[] { -2, 0, 0, 2, 2 }));
		System.out.println(threeSum(new int[] { 0, 0, 0, 0 }));
		System.out.println(threeSum(new int[] { 3, 0, -2, -1, 1, 2 }));
		System.out.println(threeSum(new int[] { -2, 0, 0, 2, 2 }));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		HashMap<Integer, Integer> map = new HashMap<>();

		List<List<Integer>> primary = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				int sum = (nums[i] + nums[j]) * -1;
				if (map.containsKey(sum) && map.get(sum) > j) {
					j = map.get(nums[j]);
					primary.add(Arrays.asList(nums[i], nums[j], sum));
				}
			}
			i = map.get(nums[i]);
			if (i > nums.length - 1)
				break;
		}
		return primary;
	}

}
