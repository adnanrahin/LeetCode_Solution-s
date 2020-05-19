package count_of_smaller_numbers_after_self_315;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {

	}

	public static List<Integer> countSmaller(int[] nums) { // Brute-Force Accepted Solution

		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int count = 0;
			for(int j = i + 1; j < nums.length; j++) {
				if(num > nums[j]) count++;
			}
			list.add(count);
		}
		
		return list;
	}

}
