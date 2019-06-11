package find_k_pairs_with_smallest_sums_373;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

	public static void main(String args[]) {

		System.out.println(kSmallestPairs(new int[] { 1, 2 }, new int[] { 3 }, 3));

	}

	public static List<int[]> kSmallestPairs(int[] a, int[] b, int k) {

		Map<pair, Integer> map = new HashMap<>();

		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (!map.containsKey(new pair(a[i], b[j]))) {
					map.put(new pair(a[i], b[j]), a[i] + b[j]);
				}
			}
		}
		PriorityQueue<Map.Entry<pair, Integer>> pQueue = new PriorityQueue<>((c, d) -> (c.getValue() - d.getValue()));

		for (Map.Entry<pair, Integer> itr : map.entrySet()) {

			pQueue.add(itr);

		}

		try {
			while (list.size() < k) {
				Map.Entry<pair, Integer> itr = pQueue.poll();

				list.add(new int[] { itr.getKey().a, itr.getKey().b });
			}
		} catch (Exception e) {

		}

		return list;
	}

	public static class pair {
		int a, b;

		public pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}
