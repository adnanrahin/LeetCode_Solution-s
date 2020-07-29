package spiral_matrix_II_59;

import java.util.Arrays;

public class Main {

    public static void main(String args[]) {

        System.out.println(Arrays.deepToString(generateMatrix(1)));
        System.out.println(Arrays.deepToString(generateMatrix(100)));
        System.out.println(Arrays.deepToString(generateMatrix(1000)));
        System.out.println(Arrays.deepToString(generateMatrix(10000)));
        System.out.println(Arrays.deepToString(generateMatrix(100000)));

    }

    public static int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int number = 1;

        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = i; j < n - i; j++)
                matrix[i][j] = number++;

            for (int j = i + 1; j < n - i; j++)
                matrix[j][n - i - 1] = number++;

            for (int j = n - i - 2; j >= i; j--)
                matrix[n - i - 1][j] = number++;

            for (int j = n - i - 2; j > i; j--)
                matrix[j][i] = number++;
        }

        return matrix;
    }

}
