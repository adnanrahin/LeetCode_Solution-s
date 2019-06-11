package combination_sum_II_40;

import java.util.*;

public class Main {

	public static void main(String args[]) {

		System.out.println(combinationSum2(new int[] { 1, 2, 3, 4 }, 7));
		System.out.println(combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
		System.out.println(combinationSum2(new int[] { 2, 3, 3, 7, 1 }, 6));
		System.out.println(combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5));
	}

	public static List<List<Integer>> ans = new ArrayList<>();

	public static List<List<Integer>> combinationSum2(int arr[], int target) {
		ans.clear();
		Arrays.sort(arr);
		findCombination(arr, target, 0, new ArrayList<>());
		return ans;
	}

	public static void findCombination(int arr[], int target, int start, List<Integer> list) {

		if (target < 0)
			return;
		if (target == 0) {
			ans.add(new ArrayList<>(list));
			return;
		}

		for (int i = start; i < arr.length; i++) {
			if (i > start && arr[i] == arr[i - 1]) // checking is there any duplicates in array, if true, then ignore case
				continue;
			else {
				list.add(arr[i]);
				findCombination(arr, target - arr[i], i + 1, list);
				list.remove(list.size() - 1); // if target is not match removing the arr[i] from the list. 
			}

		}

	}

}


// Recursion Tree Picture url: https://drive.google.com/file/d/1IddTr4aITzOBDUxQKX-lxpZIL-WouFXO/view?usp=sharing
// Recursion Tree Picture url: https://drive.google.com/file/d/1-8_llb1US6p6GBkxhQr652Cz9SY5nc2s/view?usp=sharing