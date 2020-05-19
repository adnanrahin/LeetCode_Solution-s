package maximal_rectangle_85;

import java.util.Stack;

public class Main {

    public static void main(String args[]) {

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println(maximalRectangle(matrix));

        System.out.println(maximalRectangle(new char[][]{{'1'}}));

    }

    public static int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0)
            return 0;

        int dp[] = new int[matrix[0].length];

        int maximalRectangleArea = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0')
                    dp[j] = 0;
                else
                    dp[j] = dp[j] + 1;
            }

            int currentHeight = 0;

            Stack<Integer> stack = new Stack<>();
            stack.push(-1);

            for (int j = 0; j < dp.length; j++) {
                currentHeight = dp[j];
                while (stack.peek() != -1 && currentHeight <= dp[stack.peek()]) {
                    int height = dp[stack.pop()];
                    int width = j - stack.peek() - 1;
                    maximalRectangleArea = Math.max(maximalRectangleArea, height * width);
                }
                stack.push(j);
            }

            while (stack.peek() != -1) {
                int height = dp[stack.pop()];
                int width = dp.length - stack.peek() - 1;
                maximalRectangleArea = Math.max(maximalRectangleArea, height * width);
            }

        }

        return maximalRectangleArea;
    }
}
