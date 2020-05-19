package keys_and_rooms_841;

import java.util.*;

public class Main {

	public static void main(String args[]) {

		System.out.println(canVisitAllRooms(Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList())));
		System.out.println(canVisitAllRooms(
				Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 0, 1), Arrays.asList(2), Arrays.asList(0))));

	}

	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

		boolean visited[] = new boolean[rooms.size()];
		
		for (int i = 0; i < rooms.size(); i++) {
			if(rooms.get(i).size() == 0) {
				visited[i] = true;
			}
		}

		Stack<Integer> stack = new Stack<>();
		
		visited[0] = true;
		
		depth_first_search(0, visited, stack, rooms);
		
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i])
				return false;
		}

		return true;
	}

	public static void depth_first_search(int src, boolean visited[], Stack<Integer> stack, List<List<Integer>> rooms) {

		List<Integer> list = new ArrayList<>(rooms.get(src));

		for (int i = 0; i < list.size(); i++) {
			if (!visited[list.get(i)]) {
				visited[list.get(i)] = true;
				depth_first_search(list.get(i), visited, stack, rooms);
			}
		}
		stack.push(src);
	}

}
