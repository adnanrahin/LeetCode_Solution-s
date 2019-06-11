package most_common_word_819;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String args[]) {

		System.out.println(
				mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", 
						new String[] { "hit","ball" }));

	}

	public static String mostCommonWord(String paragraph, String[] banned) {

		String ans = new String("");

		String[] words = paragraph.replaceAll("\\pP", " ").toLowerCase().split("\\s+");

		Map<String, Integer> map = new HashMap<>();

		List<String> ban = Arrays.asList(banned);

		int temp = -1;

		for (int i = 0; i < words.length; i++) {
			if (!map.containsKey(words[i]) && !ban.contains(words[i])) {
				map.put(words[i], 1);
			} else if (map.containsKey(words[i]) && !ban.contains(words[i]))
				map.replace(words[i], map.get(words[i]) + 1);

			if (map.get(words[i]) != null) {
				if (map.get(words[i]) > temp) {
					temp = map.get(words[i]);
					ans = words[i];
				}
				if(map.get(words[i]) == temp) {
					if(ans.compareTo(words[i]) >= 0)
						ans = words[i];
				}
			}
		}

		return ans;
	}

}
