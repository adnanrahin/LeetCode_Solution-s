package increasing_triplet_subsequence_334;

public class Main {

	public static void main(String args[]) {

		System.out.println(increasingTriplet(new int[] { 1, 2, 3, 4, 5, 6 }));
		System.out.println(increasingTriplet(new int[] { 4, 3, 2, 1 }));
		System.out.println(increasingTriplet(new int[] { 17, 6, 5, 7, 8, 9, 5, 6, 7, 3, 3, 4 }));
		System.out.println(increasingTriplet(new int[] { 5, 1, 5, 5, 2, 5, 4 }));
		System.out.println(increasingTriplet(new int[] { 5, 7, 1, 1, 1, 1, 8 }));

	}

	public static boolean increasingTriplet(int[] nums) {

		if (nums.length <= 2)
			return false;

		int temp = Integer.MAX_VALUE;
		int hand = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= temp)
				temp = nums[i];
			else if (nums[i] <= hand)
				hand = nums[i];
			else
				return true;
		}
		return false;
	}

}
