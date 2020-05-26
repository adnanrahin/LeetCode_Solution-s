package edit_distance_72;

public class Main {

	public static void main(String args[]) {

		System.out.println(minDistance("intention", "execution"));
		System.out.println(minDistance("horse", "ros"));
	}

	public static int minDistance(String a, String b) {

		int m = a.length();
		int n = b.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0)
					dp[i][j] = j;
				else if (j == 0)
					dp[i][j] = i;
				else if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int min = Math.min(dp[i - 1][j], dp[i][j - 1]);

					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], min);

				}
			}
		}
		return dp[m][n];
	}

}
