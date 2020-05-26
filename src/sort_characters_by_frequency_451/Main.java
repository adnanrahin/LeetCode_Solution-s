package sort_characters_by_frequency_451;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

	public static void main(String args[]) {
		System.out.println(frequencySort("tree"));
		System.out.println(frequencySort("cccaa"));
	}
	
	public static String frequencySort(String s) {

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), 1);
			} else
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> pQueue = new PriorityQueue<>(
				(a, b) -> (b.getValue() - a.getValue()));

		for (Map.Entry<Character, Integer> itr : map.entrySet()) {
			pQueue.add(itr);
		}
		
		StringBuffer stBuffer = new StringBuffer();
	
		while (!pQueue.isEmpty()) {
			Map.Entry<Character, Integer> entry = pQueue.poll();
			for (int j = 0; j < entry.getValue(); j++) {
				stBuffer.append(entry.getKey());
			}
		}

		return stBuffer.toString();
	}

}
