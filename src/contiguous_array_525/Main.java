package contiguous_array_525;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String args[]) {

    }

    public static int findMaxLength(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int count = 0;
        int longestLength = 0;

        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 1) ? 1 : -1;
            if (map.containsKey(count))
                longestLength = Math.max(longestLength, i - map.get(count));
            else map.put(count, i);
        }

        return longestLength;

    }

}
