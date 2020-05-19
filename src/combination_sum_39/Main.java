package combination_sum_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String args[]) {

		System.out.println(combinationSum(new int[] { 2, 3, 5 }, 8));
		System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));
	}

	public static List<List<Integer>> ans = new ArrayList<>();

	public static List<List<Integer>> combinationSum(int[] arr, int target) {
		ans.clear();
		Arrays.sort(arr);
		combination(arr, target, 0, new ArrayList<Integer>());
		return ans;
	}

	public static void combination(int arr[], int target, int start, List<Integer> list) {

		if (target < 0) {
			return;
		}

		if (target == 0) {
			ans.add(new ArrayList<>(list));
			return;
		}

		for (int i = start; i < arr.length; i++) {
			list.add(arr[i]);
			combination(arr, target - arr[i], start++, list);
			list.remove(list.size() - 1);
		}

	}

}
