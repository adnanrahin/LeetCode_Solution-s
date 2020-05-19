package longest_continuoust_subarray_with_absolute_diff_less_than_or_equal_to_limit_1438;

import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static int longestSubarray(int[] nums, int limit) {
        int solution = 0;

        Deque<Integer> minQueue = new LinkedList<>();
        Deque<Integer> maxQueue = new LinkedList<>();

        int left = 0, right = 0;

        while (right < nums.length) {

            while (!minQueue.isEmpty() && nums[minQueue.peekLast()] >= nums[right])
                minQueue.removeLast();

            minQueue.addLast(right);

            while (!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= nums[right])
                maxQueue.removeLast();

            maxQueue.addLast(right);

            int minIdx = minQueue.peekFirst();

            int maxIdx = maxQueue.peekFirst();

            if (nums[maxIdx] - nums[minIdx] > limit) {
                left++;
                if (left > minQueue.peekFirst()) {
                    minQueue.removeFirst();
                }
                if (left > maxQueue.peekFirst()) {
                    maxQueue.removeFirst();
                }
            } else {
                solution = Math.max(solution, right - left + 1);
                right++;
            }
        }
        return solution;
    }

}
