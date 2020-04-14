package rotting_oranges_994;

public class Main {

    public static void main(String[] args) {

    }

    static int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {

        

        return -1;
    }

    public static boolean isValid(int[][] grid, int row, int col) {
        return ((row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length));
    }

}
