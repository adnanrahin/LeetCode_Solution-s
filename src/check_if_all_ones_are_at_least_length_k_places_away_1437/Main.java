package check_if_all_ones_are_at_least_length_k_places_away_1437;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String args[]) {

    }

    public static boolean kLengthApart(int[] nums, int k) {

        if (nums.length == 0) return false;

        Map<Integer, Integer> distance = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                if (distance.containsKey(nums[i])) {
                    if (i - distance.get(1) >= k) distance.put(1, i + 1);
                    else return false;
                } else distance.put(1, i + 1);
            }

        }

        return true;
    }

}
