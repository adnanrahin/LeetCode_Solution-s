package check_if_its_a_straight_line_1232;

public class Main {

    public static void main(String args[]) {

        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};

        System.out.println(checkStraightLine(coordinates));

    }


    public static boolean checkStraightLine(int[][] coordinates) {

        double currentSlope = 0.0;
        double prevSlope = 0.0;

        if(coordinates.length == 1)
            return true;

        int x1 = coordinates[0][0];
        int x2 = coordinates[1][0];
        int y1 = coordinates[0][1];
        int y2 = coordinates[1][1];

        prevSlope = (y2 - y1) / (x2 - x1);

        System.out.println(prevSlope);

        for (int i = 1; i < coordinates.length - 1; i++) {

            x1 = coordinates[i][0];
            x2 = coordinates[i + 1][0];
            y1 = coordinates[i][1];
            y2 = coordinates[i + 1][1];
            currentSlope = (y2 - y1) / (x2 - x1);

            if (currentSlope != prevSlope)
                return false;

        }

        return true;
    }
}
