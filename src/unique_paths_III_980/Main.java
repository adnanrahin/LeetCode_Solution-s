package unique_paths_III_980;

public class Main {

    public static void main(String args[]) {

        int[][] grid = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };

        int grid2[][] = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2}
        };

        System.out.println(uniquePathsIII(grid));
        System.out.println(uniquePathsIII(grid2));

        /*
        *(0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
        (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
        (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
        (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
        * */

    }

    public static int direction[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int uniquePathsIII(int[][] grid) {

        int numberOfValidCell = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 0)
                    numberOfValidCell++;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return findThePath(i, j, grid, numberOfValidCell, 0);
                }
            }
        }

        return 0;
    }

    public static int findThePath(int row, int col, int[][] grid, int numberOfValidCell, int counter) {

        if (!isValid(row, col, grid) || grid[row][col] == -1)
            return 0;

        if (grid[row][col] == 2) {
            return numberOfValidCell == counter ? 1 : 0;
        }
        grid[row][col] = -1;
        int count = 0;

        for (int i = 0; i < 4; i++) {
            count = count + findThePath(row + direction[i][0], col + direction[i][1], grid, numberOfValidCell, counter + 1);
        }

        grid[row][col] = 0;

        return count;
    }

    public static boolean isValid(int row, int col, int[][] grid) {
        return ((row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length));
    }


}
