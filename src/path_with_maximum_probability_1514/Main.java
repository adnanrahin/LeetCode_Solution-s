package path_with_maximum_probability_1514;

import java.util.*;

public class Main {

    public static void main(String[] args) {

    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        Map<Integer, List<Pair>> graph = new HashMap<>();

        for (int i = 0; i < n; i++)
            graph.put(i, new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            graph.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }

        double[] distance = new double[n + 1];
        boolean[] visited = new boolean[n + 1];

        Arrays.fill(distance, Integer.MIN_VALUE);
        Arrays.fill(visited, false);
        dijkstra(start, graph, visited, distance);

        if (!visited[end])
            return 0.00000;

        return distance[end];
    }

    public static void dijkstra(int src, Map<Integer, List<Pair>> graph, boolean[] visited, double[] distance) {

        visited[src] = true;
        distance[src] = 0.0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0.0));

        while (!pq.isEmpty()) {
            Pair parent = pq.poll();

            visited[parent.vertex] = true;
            List<Pair> edges = graph.get(parent.vertex);

            for (Pair child : edges) {
                int childVertex = child.vertex;
                double childCost = child.cost;

                if (visited[childVertex]) continue;

                if (parent.vertex == src) {
                    if (distance[childVertex] < childCost) {
                        distance[childVertex] = childCost;
                    }
                } else {
                    if (distance[childVertex] < childCost * parent.cost) {
                        distance[childVertex] = childCost * parent.cost;
                    }
                }
                pq.add(new Pair(childVertex, distance[childVertex]));
            }
        }
    }

    public static class Pair implements Comparable<Pair> {
        double cost;
        int vertex;

        public Pair(int vertex, double cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        public int compareTo(Pair pair) {
            return Double.compare(pair.cost, this.cost);
        }

    }

}
