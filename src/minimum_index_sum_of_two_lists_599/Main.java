package minimum_index_sum_of_two_lists_599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String args[]) {

    }

    public String[] findRestaurant(String[] list1, String[] list2) {

        HashMap<String, Integer> map = new HashMap<>();
        List<String> solution = new ArrayList<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length; i++) {

            if (map.containsKey(list2[i])) {
                if (i - map.get(list2[i]) < minDistance) {
                    solution.clear();
                    solution.add(list2[i]);
                    minDistance = Math.abs(i - map.get(list2[i]));
                } else if (i - map.get(list2[i]) == minDistance) {
                    solution.add(list2[i]);
                }
            }
        }

        String[] strs = solution.toArray(new String[0]);

        return strs;
    }

}
