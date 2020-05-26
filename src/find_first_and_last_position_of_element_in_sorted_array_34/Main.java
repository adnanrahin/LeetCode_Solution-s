package find_first_and_last_position_of_element_in_sorted_array_34;

public class Main {

	public static void main(String args[]) {

	}

	public int[] searchRange(int[] nums, int target) {

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {

			int mid = (left + right) / 2;

			if (nums[mid] == target) {
				int r = mid;
				while (r <= right) {
					if (nums[r] == target)
						r++;
					else {
						break;
					}
				}
				int l = mid;
				while (l >= left) {
					if (nums[l] == target)
						l--;
					else {

						break;
					}
				}

				return new int[] { l + 1, r - 1 };

			} else if (nums[mid] > target) {
				right = mid - 1;
			} else
				left = mid + 1;
		}

		return new int[] { -1, -1 };

	}
}
