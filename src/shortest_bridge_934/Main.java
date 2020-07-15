package shortest_bridge_934;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println(shortestBridge(new int[][]{{1, 0, 0, 0, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 0}}));

    }

    public static int shortestBridge(int[][] A) {

        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();

        int count = 1;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    if (count == 1) {
                        count++;
                        list1 = depthFirstSearch(i, j, A, list1);
                    } else list2 = depthFirstSearch(i, j, A, list2);
                }
            }
        }

        int minFlip = Integer.MAX_VALUE;

        for (int i = 0; i < list1.size(); i++) {
            int x1 = list1.get(i)[0];
            int y1 = list1.get(i)[1];
            for (int j = 0; j < list2.size(); j++) {
                int x2 = list2.get(i)[0];
                int y2 = list2.get(i)[1];
                minFlip = Math.min(Math.abs(x1 - x2) + Math.abs(y1 - y2), minFlip);
            }
        }

        return minFlip == Integer.MAX_VALUE ? 0 : minFlip;
    }

    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static boolean isValid(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    public static List<int[]> depthFirstSearch(int row, int col, int[][] grid, List<int[]> solution) {

        if (!isValid(row, col, grid) || grid[row][col] == 0) return solution;

        grid[row][col] = 0;

        solution.add(new int[]{row, col});

        for (int[] dir : directions) {
            solution = depthFirstSearch(row + dir[0], col + dir[1], grid, solution);
        }

        return solution;

    }

}
