package jump_game_55;

public class Main {

	public static void main(String args[]) {

		System.out.println(canJump(new int[] { 1, 2, 1, 1, 4 }));
		System.out.println(canJump(new int[] { 3, 2, 1, 0, 1, 4 }));
		System.out.println(canJump(new int[] { 0 }));
		System.out.println(canJump(new int[] { 2, 0 }));
		System.out.println(canJump(new int[] { 1, 1, 1, 0 }));
		System.out.println(canJump(new int[] { 1, 2 }));
		System.out.println(canJump(new int[] { 2, 0, 0 }));
		System.out.println(canJump(new int[] { 2, 5, 0, 0 }));
		System.out.println(canJump(new int[] { 3, 0, 8, 2, 0, 0, 1 }));
	}

	public static boolean canJump(int[] nums) {

		if (nums.length == 0 || nums.length == 1)
			return true;

		if (nums[0] == 0 && nums.length > 1)
			return false;

		if (nums.length == 2 && nums[0] > 0)
			return true;

		int p = 0;

		for (int i = 0; i < nums.length; i++) {

			if (p >= nums.length - 1) {
				return true;
			} else if (i > p)
				return false;

			p = Math.max(p, nums[i] + i);

		}

		return false;
	}

}
