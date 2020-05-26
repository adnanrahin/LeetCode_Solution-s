package group_the_people_given_the_group_size_the_belong_to_1282;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, ArrayList<Integer>> table = new HashMap<>();

        List<List<Integer>> global = new ArrayList<>();


        for (int i = 0; i < groupSizes.length; i++) {

            int size = groupSizes[i];

            if (table.containsKey(size)) {

                table.get(size).add(i);
                if (table.get(size).size() == size) {
                    global.add(table.get(size));
                    table.remove(size);
                }

            } else {

                table.put(size, new ArrayList<>());
                table.get(size).add(i);
                if (table.get(size).size() == size) {
                    global.add(table.get(size));
                    table.remove(size);
                }
            }
        }

        return global;

    }

}
