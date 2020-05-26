package find_minimum_in_rotated_sorted_array_153;

public class Main {

	public static void main(String args[]) {

		System.out.println(findMin(new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
		System.out.println(findMin(new int[] { 2, 4, 5, 6, 1 }));
		System.out.println(findMin(new int[] { 4, -5, 0, 2, 3 }));
		System.out.println(findMin(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
		System.out.println(findMin(new int[] { 7, 6, 5, 4, 3, 2, 1 }));
		System.out.println(findMin(new int[] { 3 }));

		System.out.println(findMin(new int[] { 127, 128, 129, 132, 140, 145, 146, 148, 151, 156, 157, 162, 164, 168,
				169, 173, 185, 186, 187, 188, 189, 191, 194, 198, 203, 204, 207, 208, 210, 213, 214, 220, 223, 231, 235,
				236, 240, 241, 251, 252, 253, 255, 265, 266, 267, 273, 274, 277, 278, 280, 281, 284, 290, 291, 292, 293,
				296, 297, 298, 9, 12, 16, 17, 20, 22, 28, 33, 34, 35, 36, 37, 38, 40, 41, 46, 47, 49, 53, 58, 59, 61,
				62, 63, 65, 68, 72, 74, 80, 82, 83, 88, 89, 93, 95, 98, 100, 101, 104, 107, 111, 121, 125 }));
	}

	public static int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		if (nums.length == 1) {
			return nums[0];
		}

		if (nums[left] <= nums[right])
			return nums[left];

		int mid = 0;
		while (left <= right) {
			try {

				mid = (left + right) / 2;

				if (nums[mid] > nums[mid - 1] && nums[mid + 1] < nums[mid]) {
					return Math.min(nums[mid], nums[mid + 1]);

				} else if (nums[mid] < nums[right]) {
					right = mid;

				} else if (nums[mid] > nums[right]) {
					left = mid + 1;
				} else if (left == right) {
					return nums[right];
				}
			} catch (Exception e) {
				return Math.min(nums[mid], nums[mid + 1]);
			}
		}

		throw new NoSuchMethodError("No Solutiton Found");
	}

}
