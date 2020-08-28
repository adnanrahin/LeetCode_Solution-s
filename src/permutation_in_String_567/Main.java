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

    public static class Solution {
		public static boolean checkInclusion(String s1, String s2) {

			if (s1.length() > s2.length()) return false;

			long textHash = 1;
			long patternHash = 1;

			for (int i = 0; i < s1.length(); i++) {
				textHash = (textHash) % 231 * s1.charAt(i);
				patternHash = (patternHash) % 231 * s2.charAt(i);
			}

			if (textHash == patternHash && isEqual(s1, s2.substring(0, s1.length()))) return true;

			for (int i = s1.length(); i < s2.length(); i++) {
				patternHash /= s2.charAt(i - s1.length());
				patternHash = (patternHash) % 231 * s2.charAt(i);
				if (textHash == patternHash && isEqual(s1, s2.substring(i + 1 - s1.length(), i + 1)))
					return true;
			}
			return false;
		}

		public static boolean isEqual(String a, String b) {

			int[] freq = new int[26];

			for (int i = 0; i < a.length(); i++) {
				freq[a.charAt(i) - 'a']++;
				freq[b.charAt(i) - 'a']--;
			}
			for (int i = 0; i < 26; i++) {
				if (freq[i] != 0) return false;
			}
			return true;
		}
    }

}
