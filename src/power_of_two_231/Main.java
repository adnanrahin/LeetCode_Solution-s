package power_of_two_231;

public class Main {

	public static void main(String args[]) {

		System.out.println(isPowerOfTwo(8));

	}

	public static boolean isPowerOfTwo(int n) {

		return n > 0 && (n & n - 1) == 0;

	}

}
