package pascals_triangle_118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String args[]) {

		System.out.println(generate(5));
		System.out.println(generate(6));

	}

	public static List<List<Integer>> generate(int numRows) {

		List<List<Integer>> triangle = new ArrayList<>();

		if (numRows == 0)
			return triangle;
		if (numRows == 1) {
			triangle.add(Arrays.asList(1));
			return triangle;
		}

		triangle.add(Arrays.asList(1));
		triangle.add(Arrays.asList(1, 1));
		for (int i = 2; i < numRows; i++) {

			List<Integer> local = new ArrayList<>();

			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					local.add(1);
				} else {
					local.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
				}
			}

			triangle.add(local);

		}

		return triangle;

	}

}
