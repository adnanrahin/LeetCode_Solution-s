package reverse_string_344;

public class Main {

	public static void main(String args[]) {

	}

	public void reverseString(char[] s) {

		for (int i = 0, j = s.length - 1; i < j; i++, j--) {

			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;

		}

	}

}
