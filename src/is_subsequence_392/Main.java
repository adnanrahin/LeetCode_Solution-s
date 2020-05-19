package is_subsequence_392;

public class Main {

	public static void main(String args[]) {

		System.out.println(isSubsequence("ace", "abcde"));
		System.out.println(isSubsequence("", "gfdgd"));
		System.out.println(isSubsequence("", ""));

	}

	public static boolean isSubsequence(String s, String t) {

		if (t.length() == 0 && s.length() == 0) {
			return true;
		}

		if (t.length() == 0 && s.length() != 0)
			return false;

		int i = 0;
		int j = 0;

		while (i < t.length() && j < s.length()) {

			if (t.charAt(i) == s.charAt(j)) {
				i++;
				j++;
			} else
				i++;

			if (i == t.length() && j < s.length()) {
				return false;
			}

		}

		return true;
	}

}
