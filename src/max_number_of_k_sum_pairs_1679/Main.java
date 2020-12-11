package max_number_of_k_sum_pairs_1679;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{1, 2, 3, 4}, 5));
        System.out.println(maxOperations(new int[]{3, 1, 3, 4, 3}, 6));
    }

    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int numberOfOperation = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            int target = k - nums[i];
            if (map.containsKey(target) && map.get(nums[i]) > 0 && map.get(target) > 0) {
                map.put(nums[i], map.get(nums[i]) - 1);
                map.put(target, map.get(target) - 1);
                if (map.get(nums[i]) >= 0 && map.get(target) >= 0)
                    numberOfOperation++;
            }
        }

        return numberOfOperation;
    }
}
