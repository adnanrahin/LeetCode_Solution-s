package decompress_run_length_encoded_list_1313;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

    }

    public int[] decompressRLElist(int[] nums) {

        List<Integer> solution = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i+=2) {
            for (int j = 0; j < nums[i]; j++)
                solution.add(nums[i + 1]);
        }
        int[] result = new int[solution.size()];
        for (int i = 0; i < solution.size(); i++)
            result[i] = solution.get(i);

        return result;

    }

}
