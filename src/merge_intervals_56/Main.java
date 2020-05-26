package merge_intervals_56;

import java.util.PriorityQueue;
import java.util.Stack;

public class Main {

	public static void main(String args[]) {

		merge(new int[][] { { 1, 3 }, { 1, 2 }, { 1, 4 }, { 4, 8 }, { 8, 10 }, { 15, 18 } }); // [1 10, 15 18]
		merge(new int[][] { { 1, 4 }, { 4, 5 } }); // [1 5]
		merge(new int[][] { { 1, 4 }, { 0, 4 } }); // [0, 4]
		merge(new int[][] { { 2, 3 }, { 4, 5 }, { 6, 7 }, { 8, 9 }, { 1, 10 } }); // [1, 10]
		merge(new int[][] { { 5, 5 }, { 1, 3 }, { 3, 5 }, { 4, 6 }, { 1, 1 }, { 3, 3 }, { 5, 6 }, { 3, 3 }, { 2, 4 },
				{ 0, 0 } }); // [[0,0],[1,6]]
	}

	public static int[][] merge(int[][] intervals) {

		if (intervals.length == 0)
			return new int[][] {};

		PriorityQueue<pair> pq = new PriorityQueue<pair>((a, b) -> (a.x - b.x));

		for (int i = 0; i < intervals.length; i++) {
			pq.add(new pair(intervals[i][0], intervals[i][1]));
		}

		Stack<pair> stack = new Stack<pair>();

		stack.push(pq.poll());

		while (!pq.isEmpty()) {

			pair top = stack.peek();
			pair pqpoll = pq.poll();
			if (top.y < pqpoll.x) {
				stack.push(pqpoll);
			} else if (top.y < pqpoll.y) {
				top.y = pqpoll.y;
				stack.pop();
				stack.push(top);
			}

		}

		int[][] arr = new int[stack.size()][2];

		for (int i = 0; i < stack.size(); i++) {
			arr[i][0] = stack.get(i).x;
			arr[i][1] = stack.get(i).y;
		}

		return arr;
	}

	public static class pair {

		int x, y;

		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return Integer.toString(x) + " " + Integer.toString(y);
		}

	}

}
