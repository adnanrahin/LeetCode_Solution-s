package climbing_stairs_70;

public class Main {

	public static void main(String args[]) {

		System.out.println(climbStairs(6));

	}

	public static int climbStairs(int n) {

		int arr[] = new int[1000];

		if (n == 0)
			return 1;

		if (n == 3 || n == 2 || n == 1)
			return n;

		else {

			arr[0] = 0;
			arr[1] = 1;
			arr[2] = arr[0] + arr[1] + 1;

			for (int i = 3; i < n; i++) {
				arr[i] = arr[i - 1] + arr[i - 2];
			}

		}

		return arr[n];
	}

}
