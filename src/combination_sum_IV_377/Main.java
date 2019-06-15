package combination_sum_IV_377;

public class Main {

	public static void main(String args[]) {

		System.out.println(combinationSum4(new int[] { 1, 2, 3 }, 4));
		System.out.println(combinationSum4(new int[] { 2, 1, 3 }, 35));
		System.out.println(combinationSum4(new int[] { 2 }, 7));
		System.out.println(combinationSum4(new int[] { 2, 3, 5 }, 7));

	}

	// Dynamic Programming Solution:

	public static int combinationSum4(int[] nums, int target) {
		int[] dp = new int[target + 1];

		dp[0] = 1;

		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i >= nums[j])
					dp[i] += dp[i - nums[j]];
			}
		}
		return dp[target];
	}

	// Backtracking Solution TLE:

	static int counter;

	public static int combinationSum4backtrak(int[] nums, int target) {
		counter = 0;
		backtrack(nums, target, 0);
		return counter;
	}

	public static void backtrack(int[] nums, int target, int start) {

		if (target == 0) {
			counter++;
			return;
		}
		if (target < 0)
			return;
		for (int i = 0; i < nums.length; i++)
			backtrack(nums, target - nums[i], i);

		return;
	}

}
