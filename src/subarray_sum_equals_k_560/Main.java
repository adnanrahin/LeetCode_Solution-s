package subarray_sum_equals_k_560;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String args[]) {

        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, 2, 3, 3, 4, 2}, 5));

    }

    public static int subarraySum(int[] nums, int k) {

        int counter = 0;

        Map<Integer, Integer> table = new HashMap<>();

        table.put(0, 1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if (table.containsKey(sum - k))
                counter += table.get(sum - k);

            table.put(sum, table.getOrDefault(sum, 0) + 1);

        }

        return counter;
    }

}
