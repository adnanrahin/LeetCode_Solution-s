package find_peak_element_162;

public class Main {

    public static void main(String args[]) {

    }

    public static int findPeakElement(int[] nums) {

        int temp = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (temp < nums[i]) {
                temp = nums[i];
                index = i;
            }
        }
        return index;
    }

    class Solution {
        public int findPeakElement(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[mid + 1]) right = mid;
                else left = mid + 1;
            }
            return left;
        }
    }


}
