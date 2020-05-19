package largest_rectangle_in_histogram_84;

import java.util.Stack;

public class Main {

    public static void main(String args[]) {

    }

    public int largestRectangleArea(int[] heights) {

        int largestRectAngle = 0;
        int currentHeight = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < heights.length; i++) {

            currentHeight = heights[i];

            while (stack.peek() != -1 && currentHeight <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                largestRectAngle = Math.max(largestRectAngle, width * height);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            largestRectAngle = Math.max(largestRectAngle, width * height);
        }

        return largestRectAngle;

    }

}
