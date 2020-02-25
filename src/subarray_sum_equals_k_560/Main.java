package subarray_sum_equals_k_560;

public class Main {

    public static void main(String args[]) {

        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, 2, 3, 3, 4, 2}, 5));

    }

    public static int subarraySum(int[] nums, int k) {

        int sum = 0;
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {

            sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    counter++;
                }
            }
        }

        return counter;
    }

}
