package continuous_subarray_sum_523;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String args[]){
        System.out.println(checkSubarraySum(new int[]{0, 0}, 6));
        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(checkSubarraySum(new int[]{0, 1, 0}, 0));
    }

    public static boolean checkSubarraySum(int[] nums, int k){

        int sum = 0;

        Map<Integer, Integer> table = new HashMap<>();

        table.put(0, -1);

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            if(k != 0)
                sum %= k;

            if(table.containsKey(sum)){
                if(i - table.get(sum) > 1)
                    return true;
            }
            else table.put(sum, i);
        }

        return false;
    }

}
