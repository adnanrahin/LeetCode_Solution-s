package jump_game_II_45;

public class Main {

	public static void main(String args[]) {

		System.out.println(jump(new int[] { 1, 2, 3, 4, 5 })); // 3
		System.out.println(jump(new int[] { 2, 3, 1, 1, 4 })); // 2
		System.out.println(jump(new int[] { 1, 2, 3, 0, 5, 4, 1, 2, 1 })); // 4
		System.out.println(jump(new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0 })); // 2
		System.out.println(jump(new int[] { 2, 3, 1 })); // 0
		System.out.println(jump(new int[] { 9, 8, 2, 2, 0, 2, 2, 0, 4, 1, 5, 7, 9, 6, 6, 0, 6, 5, 0, 5 })); // 3
	}

	public static int jump(int nums[]) {

		if (nums.length == 0 || nums.length == 1)
			return 0;

		if (nums[0] == 0)
			return 0;

		if (nums.length == 2)
			return 1;

		int max = nums[0];
		int maxidx = 0;
		int counter = 0;
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {

			if (max + maxidx <= nums[i] + i) {
				max = nums[i];
				maxidx = i;
			}

			if (max + maxidx >= nums.length - 1)
				return ++counter;

			if (temp == i) {
				counter++;
				temp = max + maxidx;
			}

		}

		return counter;
	}

}
