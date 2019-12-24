package remove_duplicates_from_sorted_array_II_80;

public class Main {

    public static void main(String args[]) {


    }

    public int removeDuplicates(int[] nums) {

        if (nums == null)
            return 0;
        if (nums.length < 3)
            return nums.length;

        int i = 1;
        int j = 2;

        while (j < nums.length) {
            if (nums[i] == nums[j] && nums[j] == nums[i - 1])
                j++;
            else {
                i++;
                nums[i] = nums[j];
                j++;
            }

        }

        return i + 1;

    }

}
