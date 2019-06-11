package kth_largest_element_in_an_array_215;

import java.util.PriorityQueue;

public class Main {

	public static void main(String args[]) {

		System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
		System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
		System.out.println(findKthLargest(new int[] { -1, 0, 1, 1, 2, 3 }, 4));
	}

	public static int findKthLargest(int[] nums, int k) {
		int temp = nums[0];

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < nums.length; i++) {
			pq.add(nums[i]);
		}
		int n = pq.size() - k;
		int i = 0;
		while (i < n) {
			pq.remove();
			i++;
		}
		temp = pq.peek();

		return temp;
	}

}
