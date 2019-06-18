package next_permutation_31;

public class Main {

	public static void main(String args[]) {
		nextPermutation(new int[] { 4, 3, 1, 2, 8, 0 });
		nextPermutation(new int[] { 9, 1, 2, 4, 3, 1, 0 });
		nextPermutation(new int[] { 1, 2, 3, 4, 1 });
		nextPermutation(new int[] { 4, 3, 2, 1 });
		nextPermutation(new int[] { 5, 1, 1 });
	}

	public static void nextPermutation(int[] nums) {

		int inversepoint = -1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] < nums[i]) {
				inversepoint = i - 1;
			}
		}

		if (inversepoint == -1) {
			for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}

		else {
			for (int i = nums.length - 1; i >= 0; i--) {
				if (nums[inversepoint] < nums[i]) {
					int temp = nums[inversepoint];
					nums[inversepoint] = nums[i];
					nums[i] = temp;
					break;
				}
			}

			for (int i = inversepoint + 1, j = nums.length - 1; i < j; i++, j--) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}

	}

}
