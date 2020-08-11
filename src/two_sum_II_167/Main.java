package two_sum_II_167;

public class Main {

    public static void main(String args[]) {

    }

    public static int[] twoSum(int[] numbers, int target) {

        int ans[] = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            int key = target - numbers[i];
            int index = binary_Search(numbers, key, i + 1);
            if (index != -1) {
                return new int[]{i + 1, index + 1};
            }
        }

        return ans;
    }

    private static int binary_Search(int arr[], int target, int start) {

        int right = arr.length - 1;
        int left = start;

        while (left <= right) {
            int pivot = (left + right) / 2;

            if (arr[pivot] == target) {
                return pivot;
            } else if (target > arr[pivot]) {
                left = pivot + 1;
            } else if (target < arr[pivot]) {
                right = pivot - 1;
            }
        }

        return -1;
    }

    /*Optimized Solution for Finding Sum of Two numbers in Sorted Array*/

    public class Solution {
        public int[] twoSum(int[] numbers, int target) {

            int[] solution = {-1, -1};

            int left = 0;
            int right = numbers.length - 1;

            while (left < right) {
                if (numbers[left] + numbers[right] == target) return new int[]{left + 1, right + 1};
                else if (numbers[left] + numbers[right] > target) right--;
                else left++;
            }

            return solution;
        }
    }

}
