package binary_number_with_alternating_bits_693;

public class Main {

	public static void main(String args[]) {
		
		System.out.println(hasAlternatingBits(10));
		
	}

	public static boolean hasAlternatingBits(int n) {

		String binary = Integer.toBinaryString(n);

		for (int i = 0; i < binary.length() - 1; i++) {
			if (binary.charAt(i) == binary.charAt(i + 1))
				return false;
		}

		return true;
	}

}
