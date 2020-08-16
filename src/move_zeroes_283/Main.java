package move_zeroes_283;

public class Main {

    public static void main(String args[]) {

        moveZeroes(new int[]{0, 1, 0});

    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

    class Solution {
        public void moveZeroes(int[] nums) {

            int left = 0;
            int right = 1;

            while (left < nums.length && right < nums.length) {

                if (nums[left] != 0) {
                    left++;
                    right++;
                } else if (nums[right] == 0) right++;
                else if (nums[left] == 0 && nums[right] != 0) {
                    nums[left] = nums[right];
                    nums[right] = 0;
                    left++;
                    right++;
                }

            }

        }
    }

}
