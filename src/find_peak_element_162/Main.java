package find_peak_element_162;

public class Main {

	public static void main(String args[]) {

	}

	public static int findPeakElement(int[] nums) {

		int temp = nums[0];
		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (temp < nums[i]) {
				temp = nums[i];
				index = i;
			}
		}
		return index;
	}

}
