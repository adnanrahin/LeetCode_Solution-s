package find_minimum_in_rotated_sfoted_array_II_154;

public class Main {

    public static void main(String[] args) {

        System.out.println(findMin(new int[]{5, 6, 7, 8, 9, 9, 9, 9, 9, 9, 9, 1, 2, 3, 4}));

    }

    public static int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        return divideAndConquer(nums, 0, nums.length - 1, min);
    }

    public static int divideAndConquer(int[] nums, int start, int end, int min) {

        if (start > end) return min;

        int mid = (start + end) / 2;

        min = Math.min(min, nums[mid]);

        return Math.min(divideAndConquer(nums, start, mid - 1, min),
                divideAndConquer(nums, mid + 1, end, min));
    }

}
