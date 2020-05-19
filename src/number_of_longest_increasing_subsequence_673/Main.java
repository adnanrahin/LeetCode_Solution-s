package number_of_longest_increasing_subsequence_673;

public class Main {

	public static void main(String args[]) {

		System.out.println(findNumberOfLIS(new int[] { 2, 2, 2, 2, 2, 2 }));
		System.out.println(findNumberOfLIS(new int[] { 1, 2, 4, 3, 5, 4, 7, 2 }));
		System.out.println(findNumberOfLIS(new int[] { 1, 3, 2 }));
	}

	public static int findNumberOfLIS(int[] nums) {

		int dp[] = new int[nums.length];
		int counter = 0;
		for (int i = 0; i < dp.length; i++)
			dp[i] = 1;

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] >= nums[j] && dp[i] <= dp[j] + 1)
					dp[i] = dp[j] + 1;
				else
					dp[i] = 1;
			}
		}

		for (int i = 0; i < dp.length - 1; i++) {
			if (dp[i] > dp[i + 1]) {
				counter++;
			}
		}

		return counter;
	}

}
