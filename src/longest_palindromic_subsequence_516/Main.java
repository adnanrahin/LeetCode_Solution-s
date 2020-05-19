package longest_palindromic_subsequence_516;

public class Main {

	public static void main(String args[]) {
		System.out.println(longestPalindromeSubseq("agbdba"));
		System.out.println(longestPalindromeSubseq("abba"));
		System.out.println(longestPalindromeSubseq("bbbab"));
		System.out.println(longestPalindromeSubseq("aabaa"));
	}

	public static int longestPalindromeSubseq(String s) {

		int dp[][] = new int[s.length()][s.length()];

		for (int i = 0; i < s.length(); i++)
			dp[i][i] = 1;

		for (int i = 1; i < s.length(); i++) {
			int l = 0;
			for (int j = i; j < s.length(); j++) {

				if (s.charAt(l) == s.charAt(j) && i == 1) {
					dp[l][j] = 2;
				} else if (s.charAt(l) == s.charAt(j)) {
					dp[l][j] = dp[l + 1][j - 1] + 2;
				} else {
					dp[l][j] = Math.max(dp[l + 1][j], dp[l][j - 1]);
				}
				l++;
			}
		}
		
		return dp[0][s.length() - 1];

	}

}
