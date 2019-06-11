package maximum_product_subarray_152;

public class Main {

	public static void main(String args[]) {

		System.out.println(maxProduct(new int[] { 2, 3, 1, 0, 9, 6 }));
		System.out.println(maxProduct(new int[] { 2, 3, -2, 4 }));
		System.out.println(maxProduct(new int[] { -2, 0, -1 }));
		System.out.println(maxProduct(new int[] { 1, -1 }));
		System.out.println(maxProduct(new int[] { -3 }));
		System.out.println(maxProduct(new int[] { 0, 2 }));
		System.out.println(maxProduct(new int[] { -1, 1 }));
		System.out.println(maxProduct(new int[] { -1, 0 }));
		System.out.println(maxProduct(new int[] { 11, 0 }));
		System.out.println(maxProduct(new int[] { -4, -3, -2 }));
		System.out.println(maxProduct(new int[] { 3, -1, 4 }));
		System.out.println(maxProduct(new int[] { -2, 3, -4 }));
		System.out.println(maxProduct(new int[] { -5, 0, 2 }));
		System.out.println(maxProduct(new int[] { 2, -5, -2, -4, 3 }));
		System.out.println(maxProduct(new int[] { 2, -1, 1, 1 }));
	}

	public static int maxProduct(int[] nums) {

		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2) {
			if ((nums[0] < 0 && nums[1] < 0) || (nums[0] > 0 && nums[1] > 0))
				return nums[0] * nums[1];
			else if (nums[0] <= 0 && nums[1] >= 0)
				return nums[1];
			else if (nums[0] >= 0 && nums[1] <= 0)
				return nums[0];
		}
		int max[] = new int[nums.length];
		int min[] = new int[nums.length];

		max[0] = nums[0];
		min[0] = nums[0];
		int temp = max[0];
		for (int i = 1; i < nums.length; i++) {
			max[i] = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
			min[i] = Math.min(Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
			temp = Math.max(temp, max[i]);
		}

		return temp;

	}

}
