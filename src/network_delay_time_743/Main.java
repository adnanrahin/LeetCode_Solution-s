package network_delay_time_743;

import java.util.*;

public class Main {

    public static void main(String args[]) {

        System.out.println(new PriorityQueueSolution().networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println(new PriorityQueueSolution().networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2));
        System.out.println(new PriorityQueueSolution().networkDelayTime(new int[][]{{1, 2, 1}, {2, 1, 3}}, 2, 2));
    }

    public static class PriorityQueueSolution {
        public static int networkDelayTime(int[][] times, int N, int K) {

            Map<Integer, List<Node>> graph = new HashMap<>();

            for (int i = 1; i <= N; i++)
                graph.put(i, new ArrayList<>());

            for (int i = 0; i < times.length; i++) {
                graph.get(times[i][0]).add(new Node(times[i][1], times[i][2]));
            }

            Set<Integer> visited = new HashSet<>();
            int[] distance = new int[N + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);

            dijkstra(K, graph, visited, distance);

            if (N != visited.size()) return -1;

            int max = distance[1];
            for (int i = 1; i < distance.length; i++)
                max = Math.max(max, distance[i]);

            return max;
        }

        public static void dijkstra(int src, Map<Integer, List<Node>> graph, Set<Integer> visited, int[] distance) {

            PriorityQueue<Node> q = new PriorityQueue<>();
            visited.add(src);
            distance[src] = 0;
            q.add(new Node(src, 0));

            while (!q.isEmpty()) {

                Node parent = q.poll();
                visited.add(parent.adj);

                List<Node> adjacent = graph.get(parent.adj);

                for (int i = 0; i < adjacent.size(); i++) {
                    Node child = adjacent.get(i);
                    int v = child.adj;
                    int cst = child.cost;
                    if (!visited.contains(v)) {
                        if (distance[v] > distance[parent.adj] + cst) {
                            distance[v] = distance[parent.adj] + cst;
                            q.add(new Node(v, distance[v]));
                        }
                    }
                }
            }
        }

        public static class Node implements Comparable<Node> {
            int adj;
            int cost;

            public Node(int adj, int cost) {
                this.adj = adj;
                this.cost = cost;
            }

            public int compareTo(Node node) {
                return this.cost - node.cost;
            }

        }
    }

    public static class BellManFord {
        public int networkDelayTime(int[][] times, int N, int K) {
            int[] dist = new int[N + 1];
            Arrays.fill(dist, 0x7fffffff);
            dist[K] = 0;
            for (int i = 0; i < N; i++) {
                for (int[] edge : times) {
                    int u = edge[0];
                    int v = edge[1];
                    int cost = edge[2];
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + cost < dist[v]) dist[v] = dist[u] + cost;
                }
            }

            int max = dist[1];

            for (int i = 1; i < dist.length; i++) {
                if (dist[i] == 0x7fffffff) return -1;
                max = Math.max(dist[i], max);
            }
            return max;
        }
    }

}
