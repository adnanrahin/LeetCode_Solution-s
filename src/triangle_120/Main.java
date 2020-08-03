package triangle_120;

import java.util.*;

public class Main {

    public static void main(String args[]) {

        List<List<Integer>> test = new ArrayList<>();

        test.add(Arrays.asList(1));
        test.add(Arrays.asList(-2, -5));
        test.add(Arrays.asList(3, 6, 9));
        test.add(Arrays.asList(-1, 2, 4, -3));

        System.out.println(minimumTotal(test));

    }

    public static int minimumTotal(List<List<Integer>> triangle) {

        int[] dp = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + list.get(j);
            }
        }
        return dp[0];

    }
}
