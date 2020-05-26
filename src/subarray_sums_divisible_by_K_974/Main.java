package subarray_sums_divisible_by_K_974;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String args[]) {

        System.out.println(subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        System.out.println(subarraysDivByK(new int[]{-1, 2, 9}, 2));
    }

    public static int subarraysDivByK(int[] A, int K) {

        int sum = 0;
        int counter = 0;

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        for (int i = 0; i < A.length; i++) {

            sum += A[i];

            int mod = sum % K;

            if (mod < 0)
                mod += K;

            if (map.containsKey(mod)) {
                counter += map.get(mod);
            }

            map.put(mod, map.getOrDefault(mod, 0) + 1);

        }

        return counter;
    }

}
