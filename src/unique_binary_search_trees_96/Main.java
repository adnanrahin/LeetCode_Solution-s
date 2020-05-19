package unique_binary_search_trees_96;

public class Main {

	public static void main(String args[]) {

		System.out.println(numTrees(1));

	}

	public static int numTrees(int n) {

		if (n == 0)
			return 0;

		int[] dp = new int[n + 1];

		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}

		return dp[n];
	}

}
