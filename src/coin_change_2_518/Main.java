package coin_change_2_518;

public class Main {

	public static void main(String args[]) {
		System.out.println(change(5, new int[] { 1, 2, 5 }));
		System.out.println(change(3, new int[] { 2 }));
	}

	public static int change(int amount, int[] coins) {

		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int i = 0; i < coins.length; i++) {

			for (int j = 1; j <= amount; j++) {
				if (coins[i] <= j) {
					dp[j] += dp[j - coins[i]];
				}
			}

		}

		return dp[amount];

	}

}
