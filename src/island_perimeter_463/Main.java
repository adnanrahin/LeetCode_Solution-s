package island_perimeter_463;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

    }

    public static int[][] direction = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static boolean isValid(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    public int islandPerimeter(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int perimeter = 0;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            if (grid[i][0] == 1) perimeter++;
            if (grid[i][col - 1] == 1) perimeter++;
        }

        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 1) perimeter++;
            if (grid[row - 1][i] == 1) perimeter++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter+=breadthFirstSearch(grid, i, j, visited);
                    return perimeter;
                }
            }
        }
        return perimeter;
    }

    public static int breadthFirstSearch(int[][] gird, int row, int col, boolean[][] visited) {
        int perimeter = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {

            int[] parent = queue.poll();

            for (int[] dir : direction) {
                int r = dir[0] + parent[0];
                int c = dir[1] + parent[1];
                if (isValid(gird, r, c) && gird[r][c] == 1 && !visited[r][c]) {
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                }
                if (isValid(gird, r, c) && gird[r][c] == 0) perimeter++;

            }

        }

        return perimeter;
    }

}
