package xor_operation_in_an_array_1486;

public class Main {

    public static void main(String[] args) {

        System.out.println(new Solution().xorOperation(1, 7));

    }

    public static class Solution {
        public int xorOperation(int n, int start) {

            int[] nums = new int[n];

            int xor = 0;

            for (int i = 0; i < n; i++) {
                nums[i] = start + (2 * i);
                xor ^= nums[i];
            }

            return xor;

        }
    }

}
