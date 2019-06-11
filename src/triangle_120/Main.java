package triangle_120;

import java.util.*;

public class Main {

	public static void main(String args[]) {

		List<List<Integer>> test = new ArrayList<>();

		test.clear();

		test.add(Arrays.asList(1));
		test.add(Arrays.asList(-2, -5));
		test.add(Arrays.asList(3, 6, 9));
		test.add(Arrays.asList(-1, 2, 4, -3));

		System.out.println(minimumTotal(test));

	}

	public static int minimumTotal(List<List<Integer>> triangle) {

		int m = triangle.size();

		int dp[][] = new int[m][m];

		dp[0][0] = triangle.get(0).get(0);

		for (int i = 1; i < triangle.size(); i++) {
			
			for (int j = 0; j < triangle.get(i).size(); j++) {
				
				if (j == 0)
					dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);

				else if (j == triangle.get(i).size() - 1)
					dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);

				else
					dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);

			}
		}

		int min = dp[m - 1][0];

		for (int i = 0; i < dp[m - 1].length; i++)
			if (min > dp[m - 1][i])
				min = dp[m - 1][i];

		return min;
	}
}
