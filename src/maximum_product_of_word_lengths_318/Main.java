package maximum_product_of_word_lengths_318;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String args[]) {

		System.out.println(maxProduct(new String[] { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" }));
		System.out.println(maxProduct(new String[] { "a", "ab", "abc", "d", "cd", "bcd", "abcd" }));
		System.out.println(maxProduct(new String[] { "a", "aa", "aaa", "aaaa" }));
		
	}

	public static int maxProduct(String[] words) {
		int localmaxLen = 0;
		int globalmaxLen = 0;

		for (int i = 0; i < words.length; i++) {

			String str = words[i];

			Set<Character> strSet = new HashSet<Character>();

			for (int l = 0; l < str.length(); l++) {
				strSet.add(str.charAt(l));
			}

			for (int j = i + 1; j < words.length; j++) {
				if (!isCommon(strSet, words[j])) {
					localmaxLen = Math.max(localmaxLen, str.length() * words[j].length());
				}
			}

			globalmaxLen = Math.max(globalmaxLen, localmaxLen);

		}

		return globalmaxLen;
	}

	public static boolean isCommon(Set<Character> aSet, String b) {
		for (int i = 0; i < b.length(); i++) {
			if (aSet.contains(b.charAt(i)))
				return true;
		}
		return false;
	}

}
