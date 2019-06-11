package perfect_squares_279;

import java.util.Arrays;

public class Main {

	public static void main(String args[]) {

	}

	public static int numSquares(int n) {

		int sqrt = (int) Math.sqrt(n);

		if (sqrt * sqrt == n)
			return 1;

		int dp[] = new int[n + 1];

		Arrays.fill(dp, n);
		
		dp[0] = 0;

		for (int i = 1; i <= i; i++) {
			for (int j = 1; j * j <= n; j++) {
				dp[i] = Math.min(dp[i] + 1, dp[i - j * j] + 1);
			}
		}

		return dp[n];
	}

}
