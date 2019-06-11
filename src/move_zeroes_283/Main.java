package move_zeroes_283;

public class Main {

	public static void main(String args[]) {

		moveZeroes(new int[] { 0, 1, 0 });

	}

	public static void moveZeroes(int[] nums) {
		for (int i = 0, j = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j++] = temp;
			}

		}
	}
}
