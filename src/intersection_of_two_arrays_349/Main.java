package intersection_of_two_arrays_349;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String args[]) {

	}

	public static int[] intersection(int[] nums1, int[] nums2) {

		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> answer = new HashSet<Integer>();
		
		for(int i = 0; i < nums1.length; i++)
			set1.add(nums1[i]);
		
		for(int i = 0; i < nums2.length; i++) {
			if(set1.contains(nums2[i])) {
				answer.add(nums2[i]);
			}
		}
		
		int arr[] = new int [answer.size()];
		
		int i = 0;
		
		for(Integer itr: answer)
			arr[i++] = itr;
		
		return arr;
	}

}
