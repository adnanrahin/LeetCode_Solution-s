package max_consecutive_ones_485;

public class Main {

	public static void main(String args[]) {
		System.out.println(findMaxConsecutiveOnes(new int[] {  }));
	}

	public static int findMaxConsecutiveOnes(int[] nums) {

		if (nums.length == 0)
			return 0;

		int numberConsecutinveOnes = 0;
		int one = 0;
		int count = 0;
		boolean flag = false;
		if (nums[0] == 1) {
			count++;
			flag = true;
		}

		for (int i = 1; i < nums.length; i++) {

			if (nums[i] == 1 && !flag) {
				count++;
				flag = true;
			}
			if (nums[i] == 1 && nums[i - 1] == nums[i]) {
				one++;
			} else {
				one = 0;
			}

			numberConsecutinveOnes = Math.max(numberConsecutinveOnes, one);

		}

		return numberConsecutinveOnes > 0 ? numberConsecutinveOnes + 1 : count;

	}

}
