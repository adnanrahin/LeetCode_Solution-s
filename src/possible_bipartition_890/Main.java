package possible_bipartition_890;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String args[]) {

		System.out.println(possibleBipartition(4, new int[][] { { 1, 2 }, { 1, 3 }, { 2, 4 } }));
		System.out.println(possibleBipartition(3, new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } }));
	}

	public static List<Integer> adj[];
	public static int edge[];

	@SuppressWarnings("unchecked")
	public static boolean possibleBipartition(int N, int[][] dislikes) {

		adj = (List<Integer>[]) new List[N + 1];

		adj[0] = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < dislikes.length; i++) {
			int v1 = dislikes[i][0];
			int v2 = dislikes[i][1];
			adj[v1].add(v2);
		}

		boolean[] visited = new boolean[N + 1];
		boolean color[] = new boolean[N + 1];
		Arrays.fill(color, false);

		color[0] = false;
		visited[0] = true;

		if (isBipartite(1, visited, color))
			return true;
		else
			return false;
	}

	private static boolean isBipartite(int src, boolean visited[], boolean color[]) {
	//	visited[src] = true;
		ArrayList<Integer> list = new ArrayList<>(adj[src]);
		for (int i = 0; i < list.size(); i++) {
			if (!visited[list.get(i)]) {
				visited[list.get(i)] = true;
				color[list.get(i)] = !color[src];

				if (!isBipartite(list.get(i), visited, color))
					return false;

			} else if (color[src] == color[list.get(i)])
				return false;
		}
		return true;
	}

}
