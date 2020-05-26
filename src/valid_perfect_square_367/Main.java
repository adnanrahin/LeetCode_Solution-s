package valid_perfect_square_367;

public class Main {

	public static void main(String args[]) {
		System.out.println(isPerfectSquare(2147483647));
		System.out.println(isPerfectSquare(64));
		System.out.println(isPerfectSquare(32));
		System.out.println(isPerfectSquare(808201));
	}

	public static boolean isPerfectSquare(int key) {

		if (key == 0 || key == 1)
			return true;

		int left = 2;
		int right = key / 2;

		while (left <= right) {
			long pivot = left + (right - left) / 2;
			if (pivot * pivot == key)
				return true;
			else if (pivot * pivot > key)
				right = (int) (pivot - 1);
			else
				left = (int) (pivot + 1);
		}

		return false;
	}

}
