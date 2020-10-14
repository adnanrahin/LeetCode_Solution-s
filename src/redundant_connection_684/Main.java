package redundant_connection_684;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] red = new int[2];
        int[] dsu = new int[edges.length + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        for (int i = 0; i < edges.length; i++) {
            dsu[i + 1] = i + 1;
            pq.add(new int[]{edges[i][0], edges[i][1], i + 1});
        }

        while (!pq.isEmpty()) {

            int[] parent = pq.poll();

            int x = find(dsu, parent[0]);
            int y = find(dsu, parent[1]);

            if (x != y) {
                union(dsu, parent[0], parent[1]);
            } else {
                red[0] = parent[0];
                red[1] = parent[1];
            }

        }

        return red;
    }

    public static int find(int[] dsu, int x) {
        if (x == dsu[x]) return x;
        return find(dsu, dsu[x]);
    }

    public static void union(int[] dsu, int x, int y) {
        int xp = find(dsu, x);
        int yp = find(dsu, y);
        dsu[yp] = xp;
    }

}
