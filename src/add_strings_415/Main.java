package add_strings_415;

public class Main {

	public static void main(String args[]) {

		System.out.println(addStrings("408", "5"));

	}

	public static String addStrings(String num1, String num2) {

		if (num1.length() == 0 && num2.length() != 0)
			return num2;

		if (num2.length() == 0 && num1.length() != 0)
			return num1;

		if (num2.length() == 0 && num1.length() == 0)
			return new String();

		int n1 = num1.length();
		int n2 = num2.length();

		int carry = 0;
		String answer = new String();
		while (n1 != 0 && n2 != 0) {

			int num1int = Character.getNumericValue(num1.charAt(n1 - 1));
			int num2int = Character.getNumericValue(num2.charAt(n2 - 1));

			int sum = num1int + num2int + carry;

			int mod = sum % 10;

			carry = sum / 10;

			answer += Integer.toString(mod);

			n1--;
			n2--;
		}

		if (n1 == 0) {
			while (n2 != 0) {

				int num2int = Character.getNumericValue(num2.charAt(n2 - 1));

				int sum = num2int + carry;

				int mod = sum % 10;

				carry = sum / 10;

				answer += Integer.toString(mod);

				n2--;
			}
		}

		if (n2 == 0) {
			while (n1 != 0) {

				int num1int = Character.getNumericValue(num1.charAt(n1 - 1));

				int sum = num1int + carry;

				int mod = sum % 10;

				carry = sum / 10;

				answer += Integer.toString(mod);

				n1--;
			}
		}

		if (carry != 0) {
			answer += Integer.toString(carry);
		}

		String rev = new String();

		for (int i = answer.length() - 1; i >= 0; i--) {
			rev += Character.toString(answer.charAt(i));
		}

		return rev;
	}
}
