package first_missing_positive_41;

public class Main {

	public static void main(String args[]) {

		System.out.println(firstMissingPositive(new int[] { 1, 2, 0 }));
		System.out.println(firstMissingPositive(new int[] { 1, 2, 3, 4, 5, 6 }));
		System.out.println(firstMissingPositive(new int[] { 4, 3, -1, 1 }));
		System.out.println(firstMissingPositive(new int[] { -5 }));
		System.out.println(firstMissingPositive(new int[] { 2, 1 }));
		System.out.println(firstMissingPositive(new int[] { 1, 2, 3, 10, 2147483647, 9 }));
	}

	public static int firstMissingPositive(int[] nums) {

		boolean oneSeen = false;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) oneSeen = true;

			if (nums[i] <= 0 || nums[i] > nums.length) {
				nums[i] = 1;
			}
		}

		if (!oneSeen) return 1;

		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] > 0) nums[index] *= -1;
		}

		for (int i = 0; i < nums.length; i++)
			if (nums[i] > 0) return i + 1;

		return nums.length + 1;
	}
}
