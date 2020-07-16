package array_of_double_pair_954;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println(canReorderDoubled(new int[]{1, 2, 5, 7, 10, 14}));
        System.out.println(canReorderDoubled(new int[]{0, 0}));
        System.out.println(canReorderDoubled(new int[]{-8, -4, -2, -1, 0, 0, 1, 2, 4, 8}));
    }

    public static boolean canReorderDoubled(int[] A) {
        Arrays.sort(A);
        int counter = 0;

        Map<Integer, Integer> frequency = new HashMap<>();

        for (int value : A) {
            frequency.put(value, frequency.getOrDefault(value, 0) + 1);
        }

        if (frequency.containsKey(0)) {
            int temp = frequency.get(0);
            if (temp > 0 && temp % 2 == 0) counter += (temp / 2);
        }

        for (int value : A) {
            if (value == 0 || frequency.get(value) > 0) continue;

            if (frequency.containsKey(value * 2) && frequency.get(value * 2) > 0) {
                counter++;
                frequency.put(value * 2, frequency.get(value * 2) - 1);
                frequency.put(value, frequency.get(value) - 1);
            }

        }

        return counter == A.length / 2;
    }
}
