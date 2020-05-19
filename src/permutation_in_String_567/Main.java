package permutation_in_String_567;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String args[]) {

		System.out.println(checkInclusion("ab", "eidbaooo"));

	}

	public static boolean checkInclusion(String s1, String s2) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < s1.length(); i++) {
			if (!map.containsKey(s1.charAt(i))) {
				map.put(s1.charAt(i), 1);
			} else
				map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
		}

		int minLen = 0;
		String str = new String();
		int left = 0;
		int len = Integer.MAX_VALUE;

		HashMap<Character, Integer> seen = new HashMap<Character, Integer>();

		for (int i = 0; i < s2.length(); i++) {
			if (map.containsKey(s2.charAt(i))) {

				if (seen.containsKey(s2.charAt(i))) {

					if (map.get(s2.charAt(i)) > seen.get(s2.charAt(i))) {
						minLen++;
					}
					seen.put(s2.charAt(i), seen.get(s2.charAt(i)) + 1);
				} else {
					seen.put(s2.charAt(i), 1);
					minLen++;
				}
			}
			if (minLen == s1.length()) {
				char c = s2.charAt(left);
				while (!seen.containsKey(c) || map.get(c) < seen.get(c)) {
					if (seen.containsKey(c) && map.get(c) < seen.get(c)) {
						seen.put(c, seen.get(c) - 1);
					}
					left++;
					c = s2.charAt(left);
				}
				if (i - left + 1 < len) {
					str = s2.substring(left, i + 1);
					len = i - left + 1;
				}
			}
		}

		return (str.length() == s1.length());
	}

}
