package check_if_n_and_its_double_exist_1346;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println(checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8}));

    }


    public static boolean checkIfExist(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(2 * arr[i]) && map.get(2 * arr[i]) != i) return true;
        }

        return false;
    }

}
