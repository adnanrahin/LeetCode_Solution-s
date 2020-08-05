package single_number_136;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String args[]) {

        int arr[] = {4, 1, 2, 1, 2, 2, 2, 1, 3, 5, 6, 5, 6, 5, 6, 3};
        System.out.println(singleNumber(arr));
    }


    public static int singleNumber(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int temp = map.get(arr[i]);
                map.replace(arr[i], temp + 1);
            } else map.put(arr[i], 1);
        }

        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            if (i.getValue() == 1) {
                return i.getKey();
            }
        }

        return 0;
    }

    static class Solution { // optimized solution space O(1) and time O(n)
        public static int singleNumber(int[] nums) {
            int x = 0;
            for (int i = 0; i < nums.length; i++) {
                x = x ^ nums[i];
            }

            return x;
        }
    }

}
