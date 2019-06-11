package find_and_replace_pattern_890;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String args[]) {

		System.out.println(findAndReplacePattern(new String[] { "abc", "deq", "mee", "aqq", "dkd", "ccc" }, "abb"));
		System.out.println(findAndReplacePattern(new String[] { "abc", "cba", "xyx", "yxx", "yyx" }, "abc"));
	}

	public static List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> list = new ArrayList<>();
		int v1[] = new int[pattern.length()];
		
		v1= visited(v1, pattern);
		
		for (int i = 0; i < words.length; i++) {
			int v2[] = new int[words[i].length()];
			
			v2 = visited(v2, words[i]);

			if (Arrays.equals(v1, v2)) {
				list.add(words[i]);
			}

		}
		return list;
	}

	private static int[] visited(int[] v, String word) {
		int k = 1;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < word.length(); i++) {
			if (!map.containsKey(word.charAt(i))) {
				map.put(word.charAt(i), k++);
			}
		}
		for (int i = 0; i < word.length(); i++) {
			v[i] = map.get(word.charAt(i));
		}
		return v;
	}

}
