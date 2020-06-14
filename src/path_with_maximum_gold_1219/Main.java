package path_with_maximum_gold_1219;

public class Main {

    public static void main(String args[]) {

        System.out.println(new Solution().getMaximumGold(new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}}));

    }

    static class Solution {

        public boolean isValid(int[][] grid, int row, int col) {
            return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
        }

        public int maxSum(int[][] grid, int row, int col) {

            if (!isValid(grid, row, col) || grid[row][col] == 0) return 0;

            int gold = grid[row][col];

            int sum = gold;

            grid[row][col] = 0;

            int max = 0;

            sum+= Math.max(Math.max(maxSum(grid, row-1, col), maxSum(grid, row+1, col)),
                    Math.max(maxSum(grid, row, col-1), maxSum(grid, row, col+1)));

            grid[row][col] = gold;

            return sum;
        }

        public int getMaximumGold(int[][] grid) {
            int maxGold = 0;

            for (int i = 0; i < grid.length; i++)
                for (int j = 0; j < grid[0].length; j++)
                    if (grid[i][j] != 0) maxGold = Math.max(maxGold, maxSum(grid, i, j));

            return maxGold;
        }
    }
}
