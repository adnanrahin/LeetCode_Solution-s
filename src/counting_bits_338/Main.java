package counting_bits_338;

public class Main {

	public static void main(String args[]) {

	}

	public static int[] countBits(int num) {

		int arr[] = new int[num + 1];

		for (int i = 0; i <= num; i++) {

			arr[i] = arr[i / 2];

			if (i % 2 != 0)
				arr[i]++;
		}
		return arr;

	}

}
