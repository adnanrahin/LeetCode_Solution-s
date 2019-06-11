package coin_change_322;

public class Main {

	public static void main(String args[]) {

		System.out.println(coinChange(new int[] { 1, 2, 5 }, 6));

	}

	public static int coinChange(int[] coins, int amount) {

		int dp[] = new int[amount + 1];

		dp[0] = 1;
		
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= amount; j++) {
				dp[j] = dp[j] + dp[j - coins[i]];
			}

			for (int j = 0; j < dp.length; j++)
				System.out.print(dp[j] + " ");

			System.out.println();

		}

		return dp[amount];

	}

}
