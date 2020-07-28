package jump_game_55;

public class Main {

    public static void main(String args[]) {

        System.out.println(canJump(new int[]{1, 2, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 1, 4}));
        System.out.println(canJump(new int[]{0}));
        System.out.println(canJump(new int[]{2, 0}));
        System.out.println(canJump(new int[]{1, 1, 1, 0}));
        System.out.println(canJump(new int[]{1, 2}));
        System.out.println(canJump(new int[]{2, 0, 0}));
        System.out.println(canJump(new int[]{2, 5, 0, 0}));
        System.out.println(canJump(new int[]{3, 0, 8, 2, 0, 0, 1}));
    }

    public static boolean canJump(int[] nums) {

        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (max >= nums.length - 1) return true;
            if (i > max) return false;
            max = Math.max(nums[i] + i, max);
        }

        return false;
    }

}
