package power_of_three_326;

public class Main {

	public static void main(String args[]) {

		System.out.println(isPowerOfThree(27));

	}

	public static boolean isPowerOfThree(int n) {
		return n > 0 && 1162261467 % n == 0;
	}

}
