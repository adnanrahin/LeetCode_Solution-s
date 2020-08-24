package find_all_duplicates_in_an_array_442;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {
        System.out.println(findDuplicates(new int[]{}));
    }

    public static List<Integer> findDuplicates(int[] nums) {

        List<Integer> solution = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) solution.add(Math.abs(index + 1));
            else nums[index] = -nums[index];
        }

        return solution;

    }

}
