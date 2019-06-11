package fair_candy_swap_888;

import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String args[]) {
		
	}

	public static int[] fairCandySwap(int[] A, int[] B) {

		int sum_1 = 0, sum_2 = 0;
		
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < A.length; i++) {
			sum_1 += A[i];
		}
		for (int i = 0; i < B.length; i++) {
			set.add(B[i]);
			sum_2 += B[i];
		}
		
		int mid = (sum_1 + sum_2) / 2;
		
		for(int i = 0; i<A.length; i++) {
			int n = sum_1 - A[i];
			int mid_2 = mid - n;
			if(set.contains(mid_2)) {
				return new int[] {A[i], mid_2};
			}
		}
		throw new NoSuchMethodError("No Solution");
	}
}
