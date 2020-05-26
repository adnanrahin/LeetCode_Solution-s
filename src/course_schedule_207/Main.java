package course_schedule_207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String args[]) {

		int mat_1[][] = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 3, 1 }, { 1, 2 } }; // false
		System.out.println(canFinish(4, mat_1));

		int mat_2[][] = { { 1, 0 } }; // true
		System.out.println(canFinish(2, mat_2));

		int mat_3[][] = { { 1, 0 }, { 0, 1 } }; // false
		System.out.println(canFinish(2, mat_3));

		int mat_4[][] = { { 2, 0 }, { 1, 0 }, { 3, 1 }, { 3, 2 }, { 1, 3 } }; // false
		System.out.println(canFinish(4, mat_4));

		int mat_5[][] = { { 1, 0 }, { 2, 6 }, { 1, 7 }, { 6, 4 }, { 7, 0 }, { 0, 5 } }; // true
		System.out.println(canFinish(8, mat_5));

	}

	public static boolean visited[];
	public static int parent[];
	public static List<Integer> adj[];

	@SuppressWarnings("unchecked")
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {

		if (numCourses == 0 || numCourses == 1)
			return true;

		adj = (List<Integer>[]) new List[numCourses];

		for (int i = 0; i < numCourses; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < prerequisites.length; i++) {
			int v1 = prerequisites[i][0];
			int v2 = prerequisites[i][1];
			adj[v1].add(v2);
		}

		visited = new boolean[numCourses];
		parent = new int[numCourses];

		Arrays.fill(visited, false);
		Arrays.fill(parent, -1);

		Set<Integer> path = new HashSet<>();

		for (int i = 0; i < numCourses; i++) {
			if (!visited[i]) {
				if(hasCycle(i, visited, path))
					return false;
			}
		}
		return true;
	}

	private static boolean hasCycle(int src, boolean[] visited, Set<Integer> path) {

		visited[src] = true;
		path.add(src);
		ArrayList<Integer> list = new ArrayList<>(adj[src]);
		for (int i = 0; i < list.size(); i++) {
			if (!visited[list.get(i)]) {
				if(hasCycle(list.get(i), visited, path))
				return true;
			} else if (path.contains(list.get(i))) {
				return true;
			}
		}

		path.remove(src);

		return false;

	}

}

/* 41/42 test case pass */
