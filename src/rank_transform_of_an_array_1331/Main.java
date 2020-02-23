package rank_transform_of_an_array_1331;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String args[]) {

        arrayRankTransform(new int[]{40, 10, 20, 30});

    }

    public static int[] arrayRankTransform(int[] arr) {

        int temp[] = arr.clone();

        Arrays.sort(temp);

        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;

        for (int i = 0; i < temp.length; i++) {
            if (map.containsKey(temp[i]))
                continue;
            else
                map.put(temp[i], count++);
        }

        int solution[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            solution[i] = map.get(arr[i]);
        }

        return solution;

    }

}
