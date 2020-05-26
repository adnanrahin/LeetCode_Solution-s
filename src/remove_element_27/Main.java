package remove_element_27;

import java.util.Arrays;

public class Main {

	public static void main(String args[]) {
		int arr[] = { 3, 2, 2, 3 };
		System.out.println("Ans" + removeElement(arr, 2));
	}

	public static int removeElement(int[] nums, int val) {

		Arrays.sort(nums);
		int counter = 0;
		for (int i = 0, j = nums.length - 1; i < nums.length;) {
			if (nums[i] != val) {
				counter++;
				i++;
			} else if (nums[i] == val) {
				nums[i] = nums[j--];
				i++;
			}
		}

		return counter;
	}

}
