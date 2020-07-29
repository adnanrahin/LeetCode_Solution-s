package spiral_matrix_54;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
        System.out.println(spiralOrder(new int[][]{{3}, {2}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}}));
        System.out.println(spiralOrder(new int[][]{{7}, {9}, {6}}));
        System.out.println(spiralOrder(new int[][]{{1, 2}, {3, 4}}));
        System.out.println(
                spiralOrder(new int[][]{{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}}));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> solution = new ArrayList<>();

        if (matrix.length == 0) return solution;
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < (Math.min(row, col) + 1) / 2; i++) {
            for (int j = i; j <= col - i - 1; j++)
                solution.add(matrix[i][j]);
            for (int j = i + 1; j < row - i - 1; j++)
                solution.add(matrix[j][col - i - 1]);
            for (int j = col - i - 1; row - i - 1 != i && j >= i; j--)
                solution.add(matrix[row - i - 1][j]);
            for (int j = row - i - 2; col - i - 1 != i && j > i; j--)
                solution.add(matrix[j][i]);

        }
        return solution;
    }

}
