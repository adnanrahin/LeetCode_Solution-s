package wiggle_subsequence_376;

public class Main {

	public static void main(String args[]) {
		System.out.println(wiggleMaxLength(new int[] { 1, 7, 4, 9, 2, 5 }));
		System.out.println();
		System.out.println(wiggleMaxLength(new int[] { 7, 1, 9, 4, 5, 2 }));
		System.out.println();
		System.out.println(wiggleMaxLength(new int[] { 1, 7, 9, 4, 2, 5 }));
		System.out.println();
		System.out.println(wiggleMaxLength(new int[] { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 }));
		System.out.println();
		System.out.println(wiggleMaxLength(new int[] { 1, 2, 3, 4, 5, 6 }));
		System.out.println();
		System.out.println(wiggleMaxLength(new int[] { 3, 3, 3, 2, 5 }));
		System.out.println();
		System.out.println(wiggleMaxLength(new int[] { 0, 0, 0 }));
		System.out.println();
		System.out.println(wiggleMaxLength(new int[] { 1, 1, 7, 4, 9, 2, 5 }));
	}

	public static int wiggleMaxLength(int[] nums) {

		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return 1;
		if (nums.length == 2) {
			if (nums[0] == nums[1])
				return 1;
			else
				return 2;
		}

		int local = 0;

		boolean flag_1 = false;
		boolean flag_2 = false;

		if (nums[0] <= nums[1] && nums[1] > nums[2]) {
			local++;
			flag_1 = true;
		} else if (nums[0] > nums[1] && nums[2] > nums[1]) {
			flag_2 = true;
			local++;
		}

		for (int i = 0; i < nums.length - 2; i++) {

			if (flag_1 == true && flag_2 == false && nums[i] < nums[i + 1] && nums[i + 1] >= nums[i + 2]) {
				flag_1 = false;
				flag_2 = true;
				local++;
			} else if (flag_1 == false && flag_2 == true && nums[i] > nums[i + 1] && nums[i + 1] <= nums[i + 2]) {
				flag_1 = true;
				flag_2 = false;
				local++;
			} else if (flag_1 == false && flag_2 == false) {
				if (nums[i] <= nums[i + 1] && nums[i + 1] < nums[i + 2]) {
					local++;
					flag_2 = false;
					flag_1 = true;
				} else if (nums[i] >= nums[i + 1] && nums[i + 2] < nums[i + 1]) {
					flag_2 = true;
					flag_1 = false;
					local++;
				}
			}

		}
		return local + 1;

	}

}
