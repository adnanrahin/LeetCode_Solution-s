package word_pattern_290;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String args[]) {

		String str = new String("Dog Cat Cat Dog");
		String pattern = new String("abba");

		System.out.println(wordPattern(pattern, str));
		System.out.println(wordPattern("abba", "dog dog dog dog"));
	}

	public static boolean wordPattern(String pattern, String str) {

		boolean ans = true;
		String[] word = str.split(" ");

		if (pattern.length() != word.length)
			return false;

		Map<Character, String> map = new HashMap<>();

		for (int i = 0; i < pattern.length(); i++) {
			if (!map.containsKey(pattern.charAt(i)) && !map.containsValue(word[i])) {
				map.put(pattern.charAt(i), word[i]);
			}
		}
		for (int i = 0; i < pattern.length(); i++) {
			try {
				if (!map.get(pattern.charAt(i)).equals(word[i])) {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		}

		return ans;
	}
}
