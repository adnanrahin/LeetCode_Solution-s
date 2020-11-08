package get_maximum_in_genereated_array_1646;

public class Main {

    public static void main(String[] args) {

        System.out.println(getMaximumGenerated(3));

    }

    public static int getMaximumGenerated(int n) {
        int getMax = 0;

        if (n == 0 || n == 1) return n;

        int[] nums = new int[n + 1];
        nums[1] = 1;

        for (int i = 1; 2 * i <= n; i++) {
            int idx1 = 2 * i;
            int idx2 = 2 * i + 1;
            if (idx1 <= n) {
                nums[idx1] = nums[i];
                getMax = Math.max(nums[idx1], getMax);
            }
            if (idx2 <= n) {
                nums[idx2] = nums[i] + nums[i + 1];
                getMax = Math.max(nums[idx2], getMax);
            }
        }

        return getMax;
    }
}
