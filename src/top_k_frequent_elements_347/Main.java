package top_k_frequent_elements_347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

	public static void main(String args[]) {

		List<Integer> list = topKFrequent(
				new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6 }, 10);

		System.out.println(list);
	}

	public static List<Integer> topKFrequent(int[] nums, int k) {

		List<Integer> list = new ArrayList<>();

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				int temp = map.get(nums[i]) + 1;
				map.put(nums[i], temp);
			}

		}

		PriorityQueue<Map.Entry<Integer, Integer>> pQueue = new PriorityQueue<>((a,b) -> (b.getValue() - a.getValue()));
		
		for(Map.Entry<Integer, Integer> itr: map.entrySet()) {
			pQueue.add(itr);
		}
		
		while(list.size() < k) {
			Map.Entry<Integer, Integer> itr = pQueue.poll();
			list.add(itr.getKey());
		}
		
		
		return list;
	}

}
