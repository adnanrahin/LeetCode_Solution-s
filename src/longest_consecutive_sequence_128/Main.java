package longest_consecutive_sequence_128;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 5, 2, 5}));

    }

    public static int longestConsecutive(int[] nums) {

        int maxLen = 0;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) set.add(nums[i]);

        for (Integer num : set) {

            if (!set.contains(num - 1)) {
                int curNumber = num;
                int curLen = 0;

                while (set.contains(curNumber + 1)) {
                    curLen++;
                    curNumber++;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }

        return maxLen;
    }

}
