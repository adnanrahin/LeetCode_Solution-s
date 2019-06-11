package longest_word_in_dictionary_through_deleting_524;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String args[]) {
		System.out.println(findLongestWord("abpcplea", Arrays.asList("apple", "monkey", "plea", "ale")));
		System.out.println(findLongestWord("abpcplea", Arrays.asList("a", "b", "c")));
		System.out.println(findLongestWord("abpcplea", Arrays.asList("z", "y", "x")));
		System.out.println(findLongestWord("aaa", Arrays.asList("aaa", "aa", "a")));
		System.out.println(findLongestWord("b", Arrays.asList("a")));
		System.out.println(findLongestWord("", Arrays.asList("a", "b")));
	}

	public static String findLongestWord(String s, List<String> d) {
		
		if (s.length() == 0 || d.size() == 0)
			return "";
		
		String ans = "";

		for (String itr : d) {
			if (isStringFound(s, itr)) {
				if (itr.length() > ans.length()) {
					ans = itr;
				} else if (itr.length() == ans.length()) {

					int n = ans.compareTo(itr);
					if (n > 0) {
						ans = itr;
					}
				}
			}
		}
		return ans;
	}

	private static boolean isStringFound(String a, String b) {

		int i = 0;
		int j = 0;

		while (i < a.length() && j < b.length()) {

			if (a.charAt(i) == b.charAt(j)) {
				i++;
				j++;
			} else
				i++;

			if (i == a.length() && j < b.length()) {
				return false;
			}

		}

		return true;
	}

}
