package house_robber_II_213;

public class Main {

	public static void main(String args[]) {

		System.out.println(rob(new int[] { 2, 7, 9, 3, 1, 4, 5, 2, 6 }));
		System.out.println(rob(new int[] { 2, 3, 2 }));
		System.out.println(rob(new int[] {}));

	}

	public static int rob(int[] arr) {

		if (arr.length == 0)
			return 0;

		if (arr.length == 1)
			return arr[0];
		
		if(arr.length == 2) 
			return Math.max(arr[0], arr[1]);

		int dp1[] = new int[arr.length];
		int dp2[] = new int[arr.length];

		dp1[0] = arr[0];
		dp1[1] = Math.max(arr[0], arr[1]);

		for (int i = 2; i < arr.length - 1; i++) {
			dp1[i] = Math.max(dp1[i - 2] + arr[i], dp1[i - 1]);
		}

		dp2[0] = 0;
		dp2[1] = arr[1];
		dp2[2] = Math.max(arr[1], arr[2]);

		for (int i = 3; i < arr.length; i++) {
			dp2[i] = Math.max(dp2[i - 2] + arr[i], dp2[i - 1]);
		}

		return Math.max(dp2[arr.length - 1], dp1[arr.length - 2]);
	}

}

// [2,7,9,3,1,4,5,2,6]