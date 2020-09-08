package valid_mountain_array_941;

public class Main {

    public static void main(String[] args) {

        System.out.println(validMountainArray(new int[]{1, 2, 3, 4, 5, 5, 4, 3, 2, 1}));

    }

    public static boolean validMountainArray(int[] nums) {

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[index] < nums[i]) index = i;
        }

        for (int i = 1; i < index; i++) {
            if (nums[i - 1] >= nums[i]) return false;
        }

        for (int i = nums.length - 2; i >= index; i--) {
            if (nums[i + 1] >= nums[i]) return false;
        }

        return index != nums.length - 1 && index != 0;
    }

}
