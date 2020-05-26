package longest_palidromic_subsequence_5;

import java.util.Arrays;

public class Main {

	public static void main(String args[]) {
		String a = "forgeeksskeegfor";
		System.out.println(longestPalindrome(a));
		System.out.println(longestPalindrome("cbbd"));
		System.out.println(longestPalindrome("ccc"));
	}
	
	public static String longestPalindrome(String str) {
		
		int n = str.length();
		
		boolean dp[][] = new boolean[n+1][n+1];
		
		for(int i=0; i<n; i++) Arrays.fill(dp[i], false);
		
		for(int i=0; i<n; i++) dp[i][i] =true;
		
		int start = 0, end = 1;
		
		for(int i=0; i<n-1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				dp[i][i+1] = true;
				start = i;
				end = 2;
			}
		}

		for(int i=3; i<=n; i++) {
			for(int j=0; j<n-i+1; j++) {
				int k = i+j-1;
				if(str.charAt(j) == str.charAt(k) && dp[j+1][k-1]) {
					dp[j][k] = true;
					if(i > end) {
						start = j;
						end = i;
					}
				}
			}
		}
		
		String temp = str.substring(start, start  + end);
		
		return temp;
	}
	
}
