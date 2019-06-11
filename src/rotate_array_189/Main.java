package rotate_array_189;

public class Main {

	public static void main(String args[]) {

		rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);

	}

	public static void rotate(int[] nums, int k) {
		
		for (int i = 0; i < k; i++) {

			int temp = nums[nums.length - 1];

			for (int j = nums.length - 1; j > 0; j--) {
				nums[j] = nums[j - 1];
			}
			nums[0] = temp;
		}

	}

}
