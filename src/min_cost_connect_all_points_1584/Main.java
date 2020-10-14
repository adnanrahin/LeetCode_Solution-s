package min_cost_connect_all_points_1584;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

    }

    public int minCostConnectPoints(int[][] points) {
        int minCost = 0;
        int[] dsu = new int[points.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        for (int i = 0; i < points.length; i++) dsu[i] = i;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.add(new int[]{i, j, distance});
            }
        }

        while (!pq.isEmpty()) {
            int[] parent = pq.poll();
            int x = find(dsu, parent[0]);
            int y = find(dsu, parent[1]);
            if (x != y) {
                union(dsu, x, y);
                minCost += parent[2];
            }
        }

        return minCost;
    }

    public static int find(int[] dsu, int x) {
        if (x == dsu[x]) return x;
        return find(dsu, dsu[x]);
    }

    public static void union(int[] dsu, int x, int y) {
        int xP = find(dsu, x);
        int yP = find(dsu, y);
        dsu[yP] = xP;
    }

}
