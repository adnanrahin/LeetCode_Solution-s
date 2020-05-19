package n_repeated_element_in_size_2n_array_961;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String args[]) {

		System.out.println(repeatedNTimes(new int[] { 1, 2, 3, 3 }));
		System.out.println(repeatedNTimes(new int[] { 2, 1, 2, 5, 3, 2 }));
		System.out.println(repeatedNTimes(new int[] { 5, 1, 5, 2, 5, 3, 5, 4 }));
	}

	public static int repeatedNTimes(int A[]) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < A.length; i++) {

			if (!map.containsKey(A[i])) {
				map.put(A[i], 1);
			} else {
				map.put(A[i], map.get(A[i]) + 1);
			}

		}

		for (Map.Entry<Integer, Integer> itr : map.entrySet()) {

			/*System.out.println(itr.getKey() + " " + itr.getValue());*/
			
			if (itr.getValue() * 2 == A.length)
				return itr.getKey();

		}

		return 0;

	}

}
