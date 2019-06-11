package course_schedule_II_210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main {

	public static void main(String args[]) {

		int mat_1[][] = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 3, 1 }, { 1, 2 } }; // false
		System.out.println(findOrder(4, mat_1));

		int mat_2[][] = { { 1, 0 } }; // true
		System.out.println(findOrder(2, mat_2));

		int mat_3[][] = { { 1, 0 }, { 0, 1 } }; // false
		System.out.println(findOrder(2, mat_3));

		int mat_4[][] = { { 2, 0 }, { 1, 0 }, { 3, 1 }, { 3, 2 }, { 1, 3 } }; // false
		System.out.println(findOrder(4, mat_4));

		int mat_5[][] = { { 1, 0 }, { 2, 6 }, { 1, 7 }, { 6, 4 }, { 7, 0 }, { 0, 5 } }; // true
		System.out.println(findOrder(8, mat_5));

	}

	public static boolean[] visited;
	public static List<Integer> adj[];

	@SuppressWarnings("unchecked")

	public static int[] findOrder(int numCourses, int[][] prerequisites) {

		int arr[] = new int[numCourses];
		adj = (List<Integer>[]) new List[numCourses];

		visited = new boolean[numCourses];
		Arrays.fill(visited, false);

		for (int i = 0; i < numCourses; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < prerequisites.length; i++) {
			int v1 = prerequisites[i][0];
			int v2 = prerequisites[i][1];
			adj[v1].add(v2);
		}

		Set<Integer> path = new HashSet<>();
		for (int i = 0; i < numCourses; i++) {
			if (!visited[i]) {
				if (hasCycle(i, visited, path))
					return new int[] {};
			}
		}

		Arrays.fill(visited, false);
		Stack<Integer> S = new Stack<>();

		for (int i = 0; i < numCourses; i++) {
			if (!visited[i]) {
				topoLogical_sort(i, S);
			}
		}

		int j = 0;
		for (Integer i : S) {
			arr[j++] = i;
		}
		
		return arr;
		
	}

	private static boolean hasCycle(int src, boolean[] visited, Set<Integer> path) {

		visited[src] = true;
		path.add(src);
		ArrayList<Integer> list = new ArrayList<>(adj[src]);
		for (int i = 0; i < list.size(); i++) {
			if (!visited[list.get(i)]) {
				if (hasCycle(list.get(i), visited, path))
					return true;
			} else if (path.contains(list.get(i))) {
				return true;
			}
		}
		path.remove(src);
		return false;
	}

	private static void topoLogical_sort(int src, Stack<Integer> S) {
		visited[src] = true;
		ArrayList<Integer> list = new ArrayList<>(adj[src]);
		for (int i = 0; i < list.size(); i++) {
			if (!visited[list.get(i)]) {
				topoLogical_sort(list.get(i), S);
			}
		}
		S.push(src);
	}

}
