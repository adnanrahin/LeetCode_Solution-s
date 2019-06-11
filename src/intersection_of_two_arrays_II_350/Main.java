package intersection_of_two_arrays_II_350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String args[]) {

		System.out.println(intersect(new int[] { 4, 5, 9 }, new int[] { 4, 4, 8, 9, 9 }));
		System.out.println(intersect(new int[] { 1, 1 }, new int[] { 1 }));
		System.out.println(intersect(new int[] { 1, 3, 2 }, new int[] { 1 }));

	}

	public static int[] intersect(int[] nums1, int[] nums2) {

		List<Integer> list = new ArrayList<Integer>();

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int i = 0, j = 0;

		while (i < nums1.length && j < nums2.length) {

			if (nums1[i] == nums2[j]) {
				list.add(nums1[i]);
				i++;
				j++;
			}

			else if (nums2[j] < nums1[i]) {
				j++;
			} else
				i++;

		}

		int arr[] = new int[list.size()];

		for (int l = 0; l < list.size(); l++)
			arr[l] = list.get(l);
		
		return arr;
	}

}
