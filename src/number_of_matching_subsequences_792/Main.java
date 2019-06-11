package number_of_matching_subsequences_792;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String args[]) {
		System.out.println(numMatchingSubseq("abcde", new String[] { "a", "bb", "acd", "ace" }));
		System.out
				.println(numMatchingSubseq("dashjpjauf", new String[] { "ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax" }));
	}

	public static int numMatchingSubseq(String S, String[] words) {

		if (S.length() == 0 || words.length == 0)
			return 0;

		int ans = 0;

		char[] s = S.toCharArray();

		for (String itr : words) {
			char []b = itr.toCharArray();
			if (isStringFound(s, b)) {
				ans++;
			}
		}
		return ans;
	}

	private static boolean isStringFound(char[] a, char[] b) {
		int j = 0;
		for (int i = 0; i < a.length && j < b.length; i++)
			if (a[i] == b[j]) {
				j++;
				if (j == b.length)
					return true;
			}

		return false;
	}

}
