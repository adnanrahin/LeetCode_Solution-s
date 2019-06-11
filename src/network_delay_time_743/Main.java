package network_delay_time_743;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {

	public static void main(String args[]) {

		System.out.println(networkDelayTime(new int[][] { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } }, 4, 2));
		System.out.println(networkDelayTime(new int[][] { { 1, 2, 1 } }, 2, 2));
		System.out.println(networkDelayTime(new int[][] { { 1, 2, 1 }, { 2, 1, 3 } }, 2, 2));
	}

	public static int dist[];
	public static List<node> adj[];

	@SuppressWarnings("unchecked")
	public static int networkDelayTime(int[][] times, int N, int K) {

		adj = (List<node>[]) new List[N + 1];
		dist = new int[N + 1];
		Arrays.fill(dist, 500);

		for (int i = 0; i <= N; i++)
			adj[i] = new ArrayList<>();

		for (int[] t : times) {
			int src = t[0], dst = t[1], w = t[2];
			adj[src].add(new node(dst, w));
		}

		if (!dijkstra(K, N))
			return -1;

		int ans = 0;
		
		for (int i = 1; i <= N; i++)
			ans = Math.max(ans, dist[i]);

		return ans;
	}

	public static boolean dijkstra(int src, int N) {

		Set<Integer> visited = new HashSet<>();
		PriorityQueue<node> pq = new PriorityQueue<>((a, b) -> (b.w - a.w));
		pq.add(new node(src, 0));
		dist[src] = 0;

		while (!pq.isEmpty()) {

			node n = pq.poll();
			int u = n.u;
			visited.add(u);

			for (node i : adj[u]) {

				int v = i.u;

				if (dist[u] + i.w < dist[v]) {
					dist[v] = dist[u] + i.w;
					pq.add(new node(v, dist[v]));
				}

			}

		}

		return visited.size() == N;

	}

	public static class node {
		int u, w;

		public node(int u, int w) {
			this.u = u;
			this.w = w;
		}
	}

}
