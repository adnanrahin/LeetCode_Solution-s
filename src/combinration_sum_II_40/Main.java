package combinration_sum_II_40;

import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String args[]) {

	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {

		List<List<Integer>> primary = new ArrayList<>();

		Set<List<Integer>> set = new HashSet<>();
		
		long size = (long) Math.pow(2, candidates.length);

		for (int i = 0; i < size; i++) {

			List<Integer> local = new ArrayList<>();

			for (int j = 0; j < candidates.length; j++) {

				if ((i & (1 << j)) > 0) {
					local.add(candidates[j]);
				}

			}
			
			int sum = 0;

			Collections.sort(local);
			
			for (Integer itr : local)
				sum += itr;

			if (sum == target) {
				if (!set.contains(local)) {
					primary.add(local);
					set.add(local);
				}
			}

		}

		return primary;

	}

}
