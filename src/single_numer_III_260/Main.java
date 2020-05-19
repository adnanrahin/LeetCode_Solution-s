package single_numer_III_260;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static int[] singleNumber(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else
				map.put(nums[i], map.get(nums[i]) + 1);

		}

		int arr[] = new int[2];
		int l = 0;
		for (Map.Entry<Integer, Integer> itr : map.entrySet()) {
			if (itr.getValue() == 1) {
				arr[l++] = itr.getKey();
			}
		}
		
		return arr;
	}

}
