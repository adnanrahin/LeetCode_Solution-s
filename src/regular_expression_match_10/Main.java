package regular_expression_match_10;

public class Main {

	public static void main(String args[]) {

		System.out.println(isMatch("xaabyc", "xa*b*.c*"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("", ""));
		System.out.println(isMatch("", "a*"));
		System.out.println(isMatch("abc", "..."));
		System.out.println(isMatch("aaaa", "a.*"));
		System.out.println(isMatch("", ".*"));
		System.out.println(isMatch("", ""));
		System.out.println(isMatch("", "a"));
		System.out.println(isMatch("abb", "ab*b"));
	}

	public static boolean isMatch(String text, String pattern) {

		boolean dp[][] = new boolean[text.length() + 1][pattern.length() + 1];

		dp[0][0] = true;

		for (int i = 1; i <= pattern.length(); i++)
			if (pattern.charAt(i - 1) == '*')
				dp[0][i] = dp[0][i - 2];

		for (int i = 1; i <= text.length(); i++) {
			for (int j = 1; j <= pattern.length(); j++) {
				if (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (pattern.charAt(j - 1) == '*') {

					dp[i][j] = dp[i][j - 2];

					if (!dp[i][j]) {
						if (text.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.')
							dp[i][j] = dp[i - 1][j];
					}

				} else
					dp[i][j] = false;

			}

		}
		
		return dp[text.length()][pattern.length()];
	}

}
