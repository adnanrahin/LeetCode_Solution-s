package k_diff_pairs_in_an_array_532;

import java.util.*;

public class Main {

    public static void main(String args[]) {

        System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2));

    }

    public static int binarySearch(int[] nums, int target, int left, int right) {

        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return index;
    }


    public static int findPairs(int[] nums, int k) {
        int counter = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            else {
                if (binarySearch(nums, nums[i] + k, i + 1, nums.length - 1) > -1) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static class Solution {
        public int findPairs(int[] nums, int k) {

            Set<String> visited = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {

                    if (Math.abs(nums[i] - nums[j]) == k) {
                        String x = Integer.toString(Math.max(nums[i], nums[j]));
                        String y = Integer.toString(Math.min(nums[i], nums[j]));
                        visited.add(x + y);
                    }

                }
            }

            return visited.size();

        }
    }
}
