package top_k_frequent_words_692;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

	public static void main(String args[]) {

		List<String> list = new ArrayList<>();

		list = topKFrequent(new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" }, 4);

		System.out.println(list);

		list = topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 3);

		System.out.println(list);
	}

	public static List<String> topKFrequent(String[] words, int k) {

		List<String> frequency = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();

		for (String itr : words) {
			if (!map.containsKey(itr)) {
				map.put(itr, 1);
			} else
				map.put(itr, map.get(itr) + 1);
		}

		PriorityQueue<Map.Entry<String, Integer>> pQueue = new PriorityQueue<>((a,
				b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
		
		/* if two word's appeared same amount of time, then check lexicographical order to set the priority in Queue.
		 * 
		 * suppose ["megatron", "optimus", "ironhide", "megatron" "ironhide"]
		 * megatron, 2
		 * optimus, 1
		 * ironhide 2
		 * 
		 * then [ironhide will be in top of the heap, then megatron, because megatron frequency 2 and optimus is 1]
		 * */

		for (Map.Entry<String, Integer> itr : map.entrySet()) {
			pQueue.add(itr);
		}

		while (frequency.size() < k) {
			Map.Entry<String, Integer> entry = pQueue.poll();
			frequency.add(entry.getKey());
		}

		return frequency;

	}

}
