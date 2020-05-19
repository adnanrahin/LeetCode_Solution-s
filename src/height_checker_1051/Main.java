package height_checker_1051;

public class Main {

    public static void main(String args[]) {

        System.out.println(heightChecker(new int[]{1, 2, 1, 2, 1, 1, 1, 2, 1}));

    }

    public static int heightChecker(int[] heights) {

        int count = 0;

        for (int i = 1; i < heights.length - 1; i++) {

            if (heights[i] > heights[i + 1] || heights[i] < heights[i - 1])
                count++;

        }

        return count;

    }

}
