package palindrome_number_9;

public class Main {

	public static void main(String args[]) {
		System.out.println(isPalindrome(10));
	}

	public static boolean isPalindrome(int x) {

		if (x < 0)
			return false;

		int n = x;
		int tens = 1;
		int ans = 0;
		while (n != 0) {
			int mod = n % 10;
			n = n / 10;
			ans = ans*tens + mod ;
			if (ans != 0)
				tens = 10;
		}
		System.out.println(x + " " + ans);
		return x == ans;
	}

}
