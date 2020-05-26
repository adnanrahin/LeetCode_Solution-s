package letter_combination_of_phone_number_17;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {
		System.out.println(letterCombinations("224"));
		System.out.println(letterCombinations("23"));
	}

	public static String globalString[] = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static List<String> letterCombinations(String digits) {

		if (digits.length() == 0)
			return new ArrayList<String>();

		String str = new String();

		List<String> list = new ArrayList<String>();
		list = recur(digits, 0, str, list);

		return list;
	}

	public static List<String> recur(String digits, int start, String str, List<String> list) {

		if (str.length() == digits.length()) {
			list.add(str);
			return list;
		}

		for (int i = start; i < digits.length(); i++) {

			int index = (int) digits.charAt(i) - '0';

			for (int j = 0; j < globalString[index].length(); j++) {

				str += globalString[index].charAt(j);

				recur(digits, i + 1, str, list);

				str = str.substring(0, str.length() - 1);

			}

		}

		return list;
	}

}
