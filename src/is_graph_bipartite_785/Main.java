package is_graph_bipartite_785;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String args[]) {

		System.out.println(isBipartite(new int[][] { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } }));

	}

	public static boolean isBipartite(int[][] graph) {

		int n = graph.length - 1;

		boolean color[] = new boolean[n + 1];
		boolean visited[] = new boolean[n + 1];

		Arrays.fill(visited, false);
		Arrays.fill(color, false);

		if (!checkisBipartite(0, visited, color, graph))
			return false;
		
		/*for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				if (!checkisBipartite(i, visited, color, graph)) {
					System.out.println(i);
					return false;
				}
			}
		} */

		return true;
	}

	private static boolean checkisBipartite(int src, boolean visited[], boolean color[], int graph[][]) {
		visited[src] = true;
		ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(graph[src]).boxed().collect(Collectors.toList());
		for (int i = 0; i < list.size(); i++) {
			if (!visited[list.get(i)]) {
				visited[list.get(i)] = true;
				color[list.get(i)] = !color[src];

				if (!checkisBipartite(list.get(i), visited, color, graph))
					return false;

			} else if (color[src] == color[list.get(i)])
				return false;
		}
		return true;
	}
}
