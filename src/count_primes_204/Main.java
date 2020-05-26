package count_primes_204;

import java.util.Arrays;

public class Main {

	public static void main(String args[]) {

		System.out.println(countPrimes(10));

	}

	public static int countPrimes(int n) {

		if (n == 1 || n == 0)
			return 0;

		boolean sieve[] = new boolean[n];

		Arrays.fill(sieve, true);
		int counter = 0;
		for (int i = 2; i < sieve.length; i++) {
			for (int j = i * 2; j < sieve.length; j += i) {
				sieve[j] = false;
			}
		}

		for (int i = 2; i < n; i++) {
			if (sieve[i])
				counter++;
		}

		return counter;

	}

}
