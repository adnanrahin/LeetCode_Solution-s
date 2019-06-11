package subarray_product_less_than_K_713;

public class Main {

	public static void main(String args[]) {

		System.out.println(numSubarrayProductLessThanK(new int[] { 10, 5, 3, 2, 6 }, 100));

	}

	public static int numSubarrayProductLessThanK(int[] nums, int k) {

		int count = 0;

		long product = 1;

		for (int i = 0, j = 0; i < nums.length; i++) {

			product *= nums[i];

			while (j < i && product >= k)
				product /= nums[j++];

			if (product < k) {
				count+= (i - j + 1);
			}

		}

		return count;
	}

}
