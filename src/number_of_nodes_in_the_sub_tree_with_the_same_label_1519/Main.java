package number_of_nodes_in_the_sub_tree_with_the_same_label_1519;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    public static int[] countSubTrees(int n, int[][] edges, String labels) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], l -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], l -> new ArrayList<>()).add(edge[0]);
        }

        int[] distance = new int[n];

        getTheDistance(0, graph, labels, new HashSet<>(), distance);

        return distance;
    }

    public static int[] getTheDistance(int source, Map<Integer, List<Integer>> graph, String labels, Set<Integer> visited, int[] distance) {

        int[] carArray = new int[26];

        if (visited.add(source)) {
            char parentLabels = labels.charAt(source);
            for (Integer child : graph.getOrDefault(source, Collections.emptyList())) {
                int[] arr = getTheDistance(child, graph, labels, visited, distance);
                for (int i = 0; i < 26; i++)
                    carArray[i] += arr[i];
            }
            carArray[parentLabels - 'a']++;
            distance[source] = carArray[parentLabels - 'a'];
        }
        return carArray;
    }

}
