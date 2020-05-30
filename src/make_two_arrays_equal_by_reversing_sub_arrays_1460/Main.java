package make_two_arrays_equal_by_reversing_sub_arrays_1460;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String args[]) {

    }

    public boolean canBeEqual(int[] target, int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < target.length; i++) {
            if (!map.containsKey(target[i]) || map.get(target[i]) <= 0) return false;
            else
                map.put(target[i], map.get(target[i]) - 1);
        }

        return true;

    }
}
