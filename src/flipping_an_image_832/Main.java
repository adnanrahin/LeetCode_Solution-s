package flipping_an_image_832;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(new Solution().flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}})));

    }


    public static class Solution {
        public int[][] flipAndInvertImage(int[][] A) {

            for (int k = 0; k < A.length; k++) {
                for (int left = 0, right = A[0].length - 1; left < right; left++, right--) {
                    int temp = A[k][left];
                    A[k][left] = A[k][right];
                    A[k][right] = temp;
                }
                for (int i = 0; i < A[0].length; i++)
                    A[k][i] = 0 == A[k][i] ? 1 : 0;
            }
            return A;
        }
    }
}
