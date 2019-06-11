package monotonic_array_896;

public class Main {

	public static void main(String args[]) {
		System.out.println(isMonotonic(new int[] { 1, 3, 1 }));
	}

	public static boolean isMonotonic(int[] A) {

		int upgrade = 1;
		int downgrade = 1;

		for (int i = 0; i < A.length - 1; i++) {

			if (A[i] >= A[i + 1])
				upgrade++;

			if (A[i] <= A[i + 1])
				downgrade++;
		}

		return (A.length == upgrade || A.length == downgrade);

	}

}
