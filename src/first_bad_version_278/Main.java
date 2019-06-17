package first_bad_version_278;

public class Main {

	public static void main(String args[]) {

		System.out.println(firstBadVersion(2126753390));

	}

	public static int firstBadVersion(int n) {

		int left = 0;
		int right = n;
		int global = 0;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			System.out.println(mid);
			if (isBadVersion(mid) == true) {
				right = mid - 1;
				global = mid;
			} else if (isBadVersion(mid) == false) {
				left = mid + 1;
			}
		}

		return global;

	}

	public static boolean isBadVersion(int n) {

		if (n >= 1702766719) {
			return true;
		}
		return false;

	}
}
