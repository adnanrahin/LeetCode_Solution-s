package find_n_unique_integers_sum_up_to_zero_1304;

import java.util.Arrays;

public class Main {

    public static void main(String args[]) {

        System.out.println(Arrays.toString(new Solution().sumZero(2)));

    }

    public static class Solution {
        public int[] sumZero(int n) {

            if (n == 1) return new int[]{0};

            int[] result = new int[n];

            int left = -(n / 2);
            int right = (n / 2);

            int leftPtr = 0;
            int rightPtr = n - 1;

            while (leftPtr <= rightPtr) {
                result[leftPtr++] = left++;
                result[rightPtr--] = right--;
            }
            return result;
        }
    }
}
