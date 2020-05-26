package pascals_triangle_II_119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String args[]) {
		System.out.println(getRow(3));
		System.out.println(getRow(0));
	}

	public static List<Integer> getRow(int rowIndex) {

		List<List<Integer>> triangle = new ArrayList<>();

		triangle.add(Arrays.asList(1));
		triangle.add(Arrays.asList(1, 1));
		for (int i = 2; i <=rowIndex; i++) {

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

		return triangle.get(rowIndex);

	}

}
