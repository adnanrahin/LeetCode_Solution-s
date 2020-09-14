package check_if_its_a_straight_line_1232;

public class Main {

    public static void main(String args[]) {

        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};

        System.out.println(checkStraightLine(coordinates));

    }


    public static boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0];
        int x2 = coordinates[1][0];
        int y1 = coordinates[0][1];
        int y2 = coordinates[1][1];
        int x = x2 - x1;
        int y = y2 - y1;
        double slope = (x == 0) ? Integer.MAX_VALUE : (double) y / x;
        for (int i = 2; i < coordinates.length; i++) {

            x1 = coordinates[i - 1][0];
            x2 = coordinates[i][0];
            y1 = coordinates[i - 1][1];
            y2 = coordinates[i][1];
            x = x2 - x1;
            y = y2 - y1;
            double curSlope = (x == 0) ? Integer.MAX_VALUE : (double) y / x;
            if (slope != curSlope) return false;
        }
        return true;
    }
}
