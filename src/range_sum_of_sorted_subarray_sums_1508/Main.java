package range_sum_of_sorted_subarray_sums_1508;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 5));
    }

    public static int rangeSum(int[] nums, int n, int left, int right) {

        List<Integer> sums = new ArrayList<>();

        int mod = (int) 1e9 + 7;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = (sum + nums[j] % mod) % mod;
                sums.add(sum);
            }
        }

        Collections.sort(sums);

        int ans = 0;

        for (int i = left - 1; i < right; i++)
            ans = (ans % mod) + sums.get(i);

        return ans;
    }
}
