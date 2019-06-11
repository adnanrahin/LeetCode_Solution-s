package reverese_vowels_of_string_345;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {

		System.out.println(reverseVowels("hello"));
		System.out.println(reverseVowels("a."));
		System.out.println(reverseVowels("precipy"));

	}

	public static String reverseVowels(String s) {

		if (s.length() == 0 || s.length() == 1)
			return s;

		StringBuffer sBuffer = new StringBuffer(s);

		List<Integer> tracker = new ArrayList<>();

		for (int i = 0; i < sBuffer.length(); i++) {
			if (isvowels(sBuffer.charAt(i)))
				tracker.add(i);
		}

		if (tracker.size() == 1 || tracker.size() == 0) {
			return s;
		}

		int i = 0;
		int j = tracker.size() - 1;

		while (i < j) {
			sBuffer = swap(tracker.get(i), tracker.get(j), sBuffer);
			i++;
			j--;
		}

		return sBuffer.toString();
	}

	public static boolean isvowels(char a) {

		if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' || a == 'A' || a == 'E' || a == 'I' || a == 'O'
				|| a == 'U')
			return true;

		return false;
	}

	static StringBuffer swap(int i, int j, StringBuffer sb) {
		char temp = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, temp);
		return sb;
	}

}
