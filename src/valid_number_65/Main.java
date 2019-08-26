package valid_number_65;

public class Main {

	public static void main(String args[]) {
		System.out.println(isNumber("3."));
	}

	public static boolean isNumber(String s) {

		if (s.length() == 0 || s.equals(null))
			return false;

		s = s.trim(); // remove all space from the front and back

		if (s.length() == 0 || s.equals(null) || s.charAt(0) == 'e')
			return false; // check string start with e or length is 0 or null

		if (s.charAt(s.length() - 1) == 'e' || s.charAt(s.length() - 1) == '+' || s.charAt(s.length() - 1) == '-')
			return false; // if string end with e, +, -
		if (s.equals(".")) // if String is equal to .
			return false;
		if (s.equals("+.") || s.equals("-."))
			return false; // this part is tricky, can be solve during the parsing, for simplicity sake I
							// did that

		int signcounter = 0;
		int dotcounter = 0;

		// check number of sign in string

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '-' || s.charAt(i) == '+') {
				signcounter++;
			}
		}

		// checking number of . in string

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '.')
				dotcounter++;
		}
		if (signcounter > 1) // number of sign more than one, cause I am ignoring the very first sign
			return false;
		if (dotcounter > 1) // same here if number of dot more than one
			return false;

		if (dotcounter == 1) { // if there is only one dot in string.
			int dotpos = 0;
			for (int i = 0; i < s.length(); i++) { // find the dot position
				if (s.charAt(i) == '.') {
					dotpos = i;
				}
				int temp = dotpos + 1;
				if (temp < s.length()) { // edge case: handle string out of bound error
					if (s.charAt(dotpos + 1) == 'e') { // if after dot, next char is 'e'
						if (dotpos - 1 < 0) // edge case: handle string out of bound error
							return false;
						if (s.charAt(dotpos - 1) >= '0' && s.charAt(dotpos - 1) <= '9')
							continue; // 1.e4 is true, but .e4 is false
						else
							return false;
					}

				}
			}
		}

		for (int i = 1; i < s.length() - 1; i++) { // is there any space in string
			if (s.charAt(i) == ' ') {
				return false;
			}
		}

		int lettercounter = 0;

		for (int i = 0; i < s.length(); i++) { // is there any Alphabet except 'e'
			if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
				if (s.charAt(i) == 'e') {
					lettercounter++;
				} else
					return false;
			}
		}

		if (lettercounter > 1) // if more than one 'e'
			return false;

		int signpos = 0;

		if (signcounter == 1) {
			for (int i = 1; i < s.length(); i++) { // + or - position
				if (s.charAt(i) == '+' || s.charAt(i) == '-')
					signpos = i;
			}

			if (s.charAt(signpos - 1) != 'e') // if sign before 'e' --> 123-e5
				return false;
			if (s.charAt(signpos + 1) == 'e')
				return false;
		}

		signpos = -9;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				signpos = i;
			}
		}

		if (signpos != -9) {
			if (s.charAt(signpos + 1) == 'e')
				return false;
		}

		int epos = -9;
		int dotpos = -9;

		for (int i = 0; i < s.length(); i++) { // 124e5.55 is false but 1234.4e5 is true
			if (s.charAt(i) == 'e')
				epos = i;
			if (s.charAt(i) == '.')
				dotpos = i;
		}

		if (epos != -9 && dotpos != -9) { // if 'e' occurred before '.'
			if (epos < dotpos)
				return false;
		}

		return true;
	}

}
