package find_the_duplicate_number_287;

public class Main {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{-3, 1, -3, 4, 2}));
    }

    public static int findDuplicate(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[Math.abs(arr[i])] >= 0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            } else return Math.abs(arr[i]);

        }

        return 0;
    }

    public static class TwoPointerSolution {
        public int findDuplicate(int[] nums) {
            int fast = nums[nums[0]];
            int slow = nums[0];

            while (fast != slow) {
                fast = nums[nums[fast]];
                slow = nums[slow];
            }
            fast = 0;
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return fast;
        }
    }

}
