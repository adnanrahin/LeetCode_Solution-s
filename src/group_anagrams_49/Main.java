package group_anagrams_49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String args[]) {
		System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
	}

	public static List<List<String>> groupAnagrams(String[] str) {

		List<List<String>> anagrams = new ArrayList<>();

		Map<String, ArrayList<String>> map = new HashMap<>();

		for (int i = 0; i < str.length; i++) {

			String sortedString = sort(str[i]);

			if (map.containsKey(sortedString)) {
				map.get(sortedString).add(str[i]);
			} else {
				map.put(sortedString, new ArrayList<String>());
				map.get(sortedString).add(str[i]);
			}
		}

		for (Map.Entry<String, ArrayList<String>> itr : map.entrySet()) {

			anagrams.add(itr.getValue());

		}

		return anagrams;
	}

	private static String sort(String str) {
		char temp[] = str.toCharArray();
		Arrays.sort(temp);
		return new String(temp);
	}

}
