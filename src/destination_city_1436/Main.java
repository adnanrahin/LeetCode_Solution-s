package destination_city_1436;

import java.util.*;

public class Main {

    public static void main(String args[]) {
    }

    public static String destCity(List<List<String>> paths) {

        Map<String, Integer> graph = new HashMap<>();
        Set<String> destination = new HashSet<>();

        for (int i = 0; i < paths.size(); i++) {
            destination.add(paths.get(i).get(0));
            graph.put(paths.get(i).get(1), graph.getOrDefault(paths.get(i).get(1), 0) + 1);
        }

        for (String key : graph.keySet()) {
            if (!destination.contains(key) && graph.get(key) == 1)
                return key;
        }

        return "";

    }

}
