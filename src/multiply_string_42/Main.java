package multiply_string_42;

public class Main {

	public static void main(String args[]) {

		System.out.println(multiply("123", "456"));
		System.out.println(multiply("0", "0"));

	}

	public static String multiply(String num1, String num2) {

		if (num1.length() == 0 || num2.length() == 0)
			return "0";
		if (num1.charAt(0) == '0' || num2.charAt(0) == '0')
			return "0";

		int k = 0, l = 0;

		int arr[] = new int[num1.length() + num2.length()];

		for (int i = num1.length() - 1; i >= 0; i--) {

			k = 0;

			int carry = 0;

			int n1 = num1.charAt(i) - '0';

			for (int j = num2.length() - 1; j >= 0; j--) {
				int cal = ((num2.charAt(j) - '0') * n1) + carry + arr[k + l];
				carry = cal / 10;
				arr[l + k] = cal % 10;
				k++;
			}

			if (carry > 0) {
				arr[l + k] += carry;
			}
			l++;
		}

		StringBuffer sb = new StringBuffer();

		boolean temp = false;

		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] == 0 && !temp) {
				continue;
			} else {
				sb.append(arr[i]);
				temp = true;
			}
		}
		return sb.toString();
	}

}
