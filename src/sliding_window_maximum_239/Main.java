package sliding_window_maximum_239;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {

	}

	public static int[] maxSlidingWindow(int[] nums, int k) {

		List<Integer> answer = new ArrayList<Integer>();

		for (int i = 0; i < nums.length - k; i++) {

			int sum = nums[i];

			for (int j = i; j < i + k; j++) {

				if (sum < sum + nums[j]) {
					sum += nums[j];
				}

			}

			answer.add(sum);

		}

		int arr[] = new int[answer.size()];

		for (int i = 0; i < answer.size(); i++) {
			arr[i] = answer.get(i);
		}

		return arr;

	}

}
