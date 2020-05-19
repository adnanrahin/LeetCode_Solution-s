package occurrences_after_bigram_1078;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {
		System.out.println(findOcurrences("alice is a good girl she is a good student", "a", "good"));
		System.out.println(findOcurrences("we will we will rock you", "we", "will"));
		System.out.println(findOcurrences(
				"ypkk lnlqhmaohv lnlqhmaohv lnlqhmaohv ypkk ypkk ypkk ypkk ypkk ypkk lnlqhmaohv lnlqhmaohv lnlqhmaohv lnlqhmaohv ypkk ypkk ypkk lnlqhmaohv lnlqhmaohv ypkk",
				"lnlqhmaohv", "ypkk"));
	}

	public static String[] findOcurrences(String text, String first, String second) {

		String strarr[] = text.split(" ");
		List<String> list = new ArrayList<String>();

		for (int i = 0; i < strarr.length - 2; i++) {

			if (strarr[i].equals(first) && strarr[i + 1].equals(second)) {
				list.add(strarr[i + 2]);
			}

		}

		String[] stringArray = list.toArray(new String[0]);

		return stringArray;
	}

}
