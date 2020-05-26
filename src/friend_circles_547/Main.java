package friend_circles_547;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String args[]) {

		System.out
				.println(findCircleNum(new int[][] { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } }));

	}

	public static List<Integer>[] graph;
	public static boolean visited[];

	@SuppressWarnings("unchecked")

	public static int findCircleNum(int[][] M) {

		graph = (List<Integer>[]) new List[M.length];
		visited = new boolean[M.length];

		for (int i = 0; i < M.length; i++)
			graph[i] = new ArrayList<Integer>();

		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M.length; j++) {
				if (M[i][j] == 1) {
					graph[i].add(j);
				}
			}
		}

		int count = 0;

		for (int i = 0; i < M.length; i++) {
			if (!visited[i]) {
				dfs(i);
				count++;
			}
		}

		return count;
	}

	public static void dfs(int src) {

		Stack<Integer> stack = new Stack<Integer>();

		stack.push(src);

		visited[src] = true;

		while (!stack.isEmpty()) {
			int u = stack.peek();

			List<Integer> list = new ArrayList<Integer>(graph[u]);

			for (int i = 0; i < list.size(); i++) {
				if (!visited[list.get(i)]) {
					visited[list.get(i)] = true;
					dfs(list.get(i));
				}
			}
			stack.pop();

		}

	}

}
