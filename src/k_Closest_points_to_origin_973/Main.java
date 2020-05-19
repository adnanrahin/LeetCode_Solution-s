package k_Closest_points_to_origin_973;

import java.util.PriorityQueue;

public class Main {

    public static void main(String args[]) {

    }


    public int[][] kClosest(int[][] points, int K) {

        int[][] matrix = new int[K][2];

        PriorityQueue<point> pq = new PriorityQueue<>();

        for (int i = 0; i < points.length; i++) {
            double distance = Math.pow(points[i][0], 2) + Math.pow(points[i][2], 2);
            pq.add(new point(points[i][0], points[i][2], Math.sqrt(distance)));
        }

        for (int i = 0; i < K; i++) {
            point p = pq.poll();
            matrix[i][0] = p.x;
            matrix[i][1] = p.y;
        }
        return matrix;

    }


    public static class point implements Comparable<point> {
        int x, y;
        double distance;

        public point(int x, int y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(point point) {
            if (this.distance > point.distance) return 1;
            else if (this.distance < point.distance) return -1;
            return 0;
        }
    }

}
