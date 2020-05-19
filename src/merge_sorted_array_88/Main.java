package merge_sorted_array_88;

import java.util.Arrays;

public class Main {

	public static void main(String args[]) {

		int nums1[] = { 1, 2, 3, 4, 6, 0, 0, 0, 0, 0 };
		int nums2[] = { 2, 6, 8, 9, 9 };

		merge(nums1, 5, nums2, nums2.length);

	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		for (int i = m; i < m + n; i++) {
			nums1[i] = nums2[i - m];
		}
		Arrays.sort(nums1);

	}

}
