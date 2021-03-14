package find_center_of_start_graph_1791;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

    }

    public static int findCenter(int[][] edges) {

        int centerNode = 0;

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] arr : edges) {
            if (!graph.containsKey(arr[0])) {
                graph.put(arr[0], new ArrayList<>());
            }
            if (!graph.containsKey(arr[1])) {
                graph.put(arr[1], new ArrayList<>());
            }
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }

        for (Integer keys : graph.keySet()) {
            if (graph.get(keys).size() == graph.size() - 1) {
                centerNode = keys;
            }
        }

        return centerNode;
    }

}
