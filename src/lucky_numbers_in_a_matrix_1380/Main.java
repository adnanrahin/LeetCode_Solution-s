package lucky_numbers_in_a_matrix_1380;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Integer> luckyNumbers(int[][] matrix) {

        List<Integer> solution = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int colIndex = 0;

            for (int j = 0; j < col; j++) {
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                    colIndex = j;
                }
            }
            for (int j = 0; j < row; j++) {
                max = Math.max(max, matrix[j][colIndex]);
            }
            if (min == max)
                solution.add(min);
        }

        return solution;

    }

}
