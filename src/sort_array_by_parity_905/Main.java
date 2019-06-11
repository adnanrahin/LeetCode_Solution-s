package sort_array_by_parity_905;

public class Main {

	public static void main(String args[]) {

	}

	public int[] sortArrayByParity(int[] A) {

		if(A.length == 0) return new int [] {};
		
		int primary[] = new int[A.length];

		int l = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				primary[l++] = A[i];
			}
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 != 0) {
				primary[l++] = A[i];
			}
		}

		return primary;

	}

}
