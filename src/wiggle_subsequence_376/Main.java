package wiggle_subsequence_376;

public class Main {

    public static void main(String args[]) {
        System.out.println(wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
        System.out.println(wiggleMaxLength(new int[]{7, 1, 9, 4, 5, 2}));
        System.out.println(wiggleMaxLength(new int[]{1, 7, 9, 4, 2, 5}));
        System.out.println(wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        System.out.println(wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(wiggleMaxLength(new int[]{3, 3, 3, 2, 5}));
        System.out.println(wiggleMaxLength(new int[]{0, 0, 0}));
        System.out.println(wiggleMaxLength(new int[]{1, 1, 7, 4, 9, 2, 5}));
    }

    public static int wiggleMaxLength(int[] nums) {

        if (nums.length < 2) return nums.length;
        int dif = nums[1] - nums[0];
        int counter = (dif == 0) ? 1 : 2;

        for (int i = 2; i < nums.length; i++) {
            int currentDiff = nums[i] - nums[i - 1];
            if ((currentDiff > 0 && dif <= 0) || (currentDiff < 0 && dif >= 0)) {
                counter++;
                dif = currentDiff;
            }
        }

        return counter;
    }

}
