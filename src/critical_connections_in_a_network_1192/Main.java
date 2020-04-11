package critical_connections_in_a_network_1192;

import java.util.*;

public class Main {

    public static void main(String args[]) {


        List<List<Integer>> connections = new ArrayList<>();

        connections.add(new ArrayList<>(Arrays.asList(0, 1)));
        connections.add(new ArrayList<>(Arrays.asList(1, 2)));
        connections.add(new ArrayList<>(Arrays.asList(2, 0)));
        connections.add(new ArrayList<>(Arrays.asList(1, 3)));

        System.out.println(criticalConnections(4, connections));

    }

    static int time;
    static List<List<Integer>> solution;

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        time = 0;
        solution = new ArrayList<>();

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++)
            graph.put(i, new ArrayList<>());

        for (int i = 0; i < connections.size(); i++) {
            graph.get(connections.get(i).get(1)).add(connections.get(i).get(0));
            graph.get(connections.get(i).get(0)).add(connections.get(i).get(1));
        }

        boolean[] visited = new boolean[n];
        int[] low = new int[n];
        int[] parent = new int[n];
        int[] discover = new int[n];

        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                depthFirstSearch(graph, i, visited, low, parent, discover);
            }
        }

        return solution;
    }

    public static void depthFirstSearch(Map<Integer, List<Integer>> graph, int src, boolean[] visited, int[] low, int[] parent, int[] discover) {

        visited[src] = true;

        discover[src] = low[src] = time++;

        List<Integer> adjacent = graph.get(src);

        for (int i = 0; i < adjacent.size(); i++) {
            if (!visited[adjacent.get(i)]) {
                parent[adjacent.get(i)] = src;
                depthFirstSearch(graph, adjacent.get(i), visited, low, parent, discover);
                low[src] = Math.min(low[src], low[adjacent.get(i)]);
                if (discover[src] < low[adjacent.get(i)]) solution.add(Arrays.asList(src, adjacent.get(i)));
            } else if (adjacent.get(i) != parent[src])
                low[src] = Math.min(low[src], discover[adjacent.get(i)]);
        }


    }


}
