package longest_increasing_subsequence_300;

public class Main {

	public static void main(String args[]) {

	}

	public static int lengthOfLIS(int[] nums) {

		if(nums.length == 0)
			return 0;
		
		if(nums.length == 1)
			return 1;
		
		int[] dp = new int[nums.length];

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if(nums[i] > nums[j] && dp[i] < dp[j] + 1)
					dp[i] = dp[j] + 1;
			}
		}
		
		int max = dp[0];
		
		for(int i = 0 ; i < dp.length; i++)
			if(max < dp[i])
				max = dp[i];
		
		return max + 1;

	}

}
