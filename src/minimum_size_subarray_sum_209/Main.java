package minimum_size_subarray_sum_209;

public class Main {

	public static void main(String args[]) {

		System.out.println(minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
		System.out.println(minSubArrayLen(5, new int[] { 2, 3, 1, 2, 2, 3 }));
		System.out.println(minSubArrayLen(15, new int[] { 1, 2, 3, 4, 5 }));
	}

	public static int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0)
			return 0;
		int len = nums.length + 1;
		int sum = 0;
		int l = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (s <= sum) {

				len = Math.min(len, i - l + 1);
				sum -= nums[l++];
			}
		}
		return len == nums.length + 1 ? 0 : len;
	}

}
