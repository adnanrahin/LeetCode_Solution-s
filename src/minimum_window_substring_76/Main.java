package minimum_window_substring_76;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String args[]) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}

	public static String minWindow(String s, String t) {

		String minimumSubString = new String();

		Map<Character, Integer> hashtable = new HashMap<Character, Integer>();

		for (int i = 0; i < t.length(); i++) {
			if (!hashtable.containsKey(t.charAt(i)))
				hashtable.put(t.charAt(i), 1);
			else
				hashtable.put(t.charAt(i), hashtable.get(t.charAt(i)) + 1);
		}

		Map<Character, Integer> seen = new HashMap<Character, Integer>();

		int curlen = 0;
		int left = 0;
		int minlen = Integer.MAX_VALUE;

		for (int i = 0; i < s.length(); i++) {

			if (hashtable.containsKey(s.charAt(i))) {
				if (seen.containsKey(s.charAt(i))) {
					if (hashtable.get(s.charAt(i)) > seen.get(s.charAt(i))) {
						curlen++;
					}
					seen.put(s.charAt(i), seen.get(s.charAt(i)) + 1);
				} else {
					seen.put(s.charAt(i), 1);
					curlen++;
				}
			}
			if (curlen == t.length()) {
				char c = s.charAt(left);
				while (!seen.containsKey(c) || hashtable.get(c) < seen.get(c)) {
					if (seen.containsKey(c) && hashtable.get(c) < seen.get(c)) {
						seen.put(c, seen.get(c) - 1);
					}
					left++;
					c = s.charAt(left);
				}
				if (i - left + 1 < minlen) {
					minimumSubString = s.substring(left, i + 1);
					minlen = i - left + 1;
				}
			}

		}

		return minimumSubString;
	}
}
