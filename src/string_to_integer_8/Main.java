package string_to_integer_8;

public class Main {

	public static void main(String args[]) {

		System.out.println(myAtoi("-4193 with words"));
		System.out.println(myAtoi("words and -987"));
		System.out.println(myAtoi("-908070k3939fdsjaisjfjkasdfjkasdj6453fkaklfjsd"));
		System.out.println(myAtoi("-91283472332"));
		System.out.println(myAtoi("+91283472332"));
		System.out.println(myAtoi(".14159"));
	}

	public static int myAtoi(String str) {
		str = str.trim();
		if (str.equals(""))
			return 0;
		if (str.equals("-"))
			return 0;
		if (str.equals("+"))
			return 0;
		str = str.trim();
		StringBuffer sb = new StringBuffer();

		if (Character.isLetter(str.charAt(0)))
			return 0;
		if (str.charAt(0) == '.')
			return 0;

		if (str.charAt(0) == '-' && !Character.isDigit(str.charAt(1)))
			return 0;

		if (str.charAt(0) == '+' && !Character.isDigit(str.charAt(1)))
			return 0;

		try {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) >= '0' && str.charAt(i) <= '9' || (str.charAt(i) == '-') || (str.charAt(i) == '+')) {
					sb.append(str.charAt(i));
					if (!Character.isDigit(str.charAt(i + 1)))
						break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		char a = sb.toString().charAt(0);
		boolean temp = false;

		if (a == '-')
			temp = true;

		if (temp == true)
			sb.deleteCharAt(0);

		str = sb.toString();
		long sum;
		try {
			sum = Long.valueOf(str);
		} catch (Exception e) {
			if (temp == true)
				return Integer.MIN_VALUE;
			else
				return Integer.MAX_VALUE;
		}

		if (temp == true) {
			if (-1 * sum < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
			return (int) sum * -1;
		} else {
			if (sum > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			return (int) sum;
		}
	}

}
