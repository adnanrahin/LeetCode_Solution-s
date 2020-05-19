package maximum_subarray_53;

public class Main {

	public static void main(String args[]) {
		
	}
	
	public int maxSubArray(int[] arr) {

		int ans = arr[0];
		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {

			max = Math.max(arr[i], max + arr[i]);

			if (max > ans) {
				ans = max;
			}

		}
		return ans;
	}

}
