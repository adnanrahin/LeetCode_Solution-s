package majority_element_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String args[]) {

        System.out.println(majorityElement(new int[]{3}));

    }

    public static List<Integer> majorityElement(int[] nums) {

        int third = (int) Math.floor(nums.length / 3);

        List<Integer> solution = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        for (Integer number : map.keySet()) {
            if (map.get(number) > third) solution.add(number);
        }

        return solution;

    }

}
