package search_a_2d_matrix_74;

public class Main {

    public static void main(String args[]) {

        int[][] matrix = {{1, 3, 5, 7,}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(matrix, 11));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        for (int[] ints : matrix) {
            int lo = 0;
            int high = matrix[0].length - 1;

            while (lo <= high) {
                int mid = lo + (high - lo) / 2;
                if (ints[mid] == target) return true;
                else if (ints[mid] > target) high = mid - 1;
                else lo = mid + 1;
            }
        }
        return false;

    }

}
