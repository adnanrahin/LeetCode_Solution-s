package minimum_moves_to_equal_arraye_elements_453;

public class Main {

	public static void main(String args[]) {

	}

	public static int minMoves(int[] nums) {
		int ans = 0;

		int min = nums[0];

		for (int i = 0; i < nums.length; i++) {
			ans += nums[i];
			if (min > nums[i])
				min = nums[i];
		}
		return ans - (min*nums.length);
	}

}
