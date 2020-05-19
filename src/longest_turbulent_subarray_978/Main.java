package longest_turbulent_subarray_978;

public class Main {
	public static void main(String args[]) {

		System.out.println(maxTurbulenceSize(new int[] { 9, 4, 2, 10, 7, 8, 8, 1, 9 }));
		System.out.println(maxTurbulenceSize(new int[] { 4, 8, 2, 16 }));

	}

	public static int maxTurbulenceSize(int[] nums) {

		int max = 0;
		int count = 0;

		for (int i = 0; i < nums.length - 2; i++) {
			if ((nums[i] < nums[i + 1] && nums[i + 1] > nums[i + 2])) {
				count++;
			} else if ((nums[i] > nums[i + 1] && nums[i + 1] < nums[i + 2])) {
				count++;
			} else
				count = 0;

			if (max < count) {
				max = count;
			}
		}

		return max + 2;

	}
}
