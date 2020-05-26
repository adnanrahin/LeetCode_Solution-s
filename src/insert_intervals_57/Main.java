package insert_intervals_57;

import java.util.PriorityQueue;
import java.util.Stack;

public class Main {

	public static void main(String args[]) {
		insert(new int[][] { { 1, 3 }, { 6, 9 } }, new int[] { 2, 5 });
	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {

		PriorityQueue<Intervals> pq = new PriorityQueue<Intervals>((a, b) -> (a.start - b.start));

		pq.add(new Intervals(newInterval[0], newInterval[1]));

		for (int i = 0; i < intervals.length; i++) {
			pq.add(new Intervals(intervals[i][0], intervals[i][1]));
		}

		Stack<Intervals> stack = new Stack<Intervals>();

		System.out.println(pq);

		stack.push(pq.poll());

		while (!pq.isEmpty()) {

			Intervals top = stack.peek();
			Intervals pqPoll = pq.poll();

			if (top.end < pqPoll.start) {
				stack.push(pqPoll);
			} else if (top.end < pqPoll.end) {
				top.end = pqPoll.end;
				stack.pop();
				stack.push(top);
			}
		}

		System.out.println(stack);

		int arr[][] = new int[stack.size()][2];

		for (int i = 0; i < stack.size(); i++) {
			arr[i][0] = stack.get(i).start;
			arr[i][1] = stack.get(i).end;
		}

		return arr;

	}

	public static class Intervals {

		int start;
		int end;

		public Intervals(int start, int end) {
			this.start = start;
			this.end = end;
		}

	}
}
