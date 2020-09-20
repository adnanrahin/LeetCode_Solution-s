package rotting_oranges_994;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
    }

    static int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static int orangesRotting(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int oneCounter = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) queue.add(new int[]{i, j, 0});
                if (grid[i][j] == 1) oneCounter++;
            }
        }

        int visitedOne = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            int[] parent = queue.poll();
            max = Math.max(max, parent[2]);
            for (int[] dir : directions) {
                int r = dir[0] + parent[0];
                int c = dir[1] + parent[1];
                if (isValid(grid, r, c) && grid[r][c] == 1) {
                    visitedOne++;
                    grid[r][c] = 2;
                    queue.add(new int[]{r, c, parent[2] + 1});
                }
            }
        }
        return (visitedOne == oneCounter) ? max : -1;
    }

    public static boolean isValid(int[][] grid, int row, int col) {
        return ((row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length));
    }

}
