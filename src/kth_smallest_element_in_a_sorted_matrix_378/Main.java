package kth_smallest_element_in_a_sorted_matrix_378;

import java.util.PriorityQueue;

public class Main {

	public static void main(String args[]) {

		System.out.println(kthSmallest(new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } }, 8));
		System.out.println(kthSmallest(
				new int[][] { { 1, 2, 3, 4 }, { 5, 10, 11, 15 }, { 6, 11, 13, 15 }, { 6, 13, 14, 17 } }, 8));

	}

	public static int kthSmallest(int[][] matrix, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				pq.add(matrix[i][j]);
			}
		}
		int i = 1;
		while (i < k) {
			pq.poll();
			i++;
		}

		return pq.peek();
	}
}
