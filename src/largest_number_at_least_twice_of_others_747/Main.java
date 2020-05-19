package largest_number_at_least_twice_of_others_747;

public class Main {

    public static void main(String args[]) {

        System.out.println(dominantIndex(new int[]{1, 3, 5, 32, 4, 5}));

    }

    public static int dominantIndex(int[] nums) {
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex && nums[maxIndex] < 2 * nums[i]) return -1;
        }

        return maxIndex;

    }

}
