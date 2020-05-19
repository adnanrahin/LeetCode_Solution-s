package reverse_only_letters_917;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static String reverseOnlyLetters(String s) {

		if (s.length() == 0 || s.length() == 1)
			return s;

		StringBuffer sBuffer = new StringBuffer(s);

		List<Integer> tracker = new ArrayList<>();

		for (int i = 0; i < sBuffer.length(); i++) {
			if (Character.isLetter(sBuffer.charAt(i)))
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

	static StringBuffer swap(int i, int j, StringBuffer sb) {
		char temp = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, temp);
		return sb;
	}

}
