package camelcase_matching_1023;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {

		String quString[] = { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" };
		String pattern = "FB";

		System.out.println(camelMatch(quString, pattern));

	}

	public static List<Boolean> camelMatch(String[] queries, String pattern) {

		List<Boolean> booleanList = new ArrayList<Boolean>();

		int patterncounert = 0;

		for (int i = 0; i < pattern.length(); i++) {
			if (Character.isUpperCase(pattern.charAt(i)))
				patterncounert++;
		}

		for (int i = 0; i < queries.length; i++) {

			String str = queries[i];

			int strcounter = 0;

			for (int j = 0; j < str.length(); j++) {
				if (Character.isUpperCase(str.charAt(j))) {
					strcounter++;
				}
			}

			if (isSubsequence(str, pattern) && patterncounert == strcounter)
				booleanList.add(true);
			else
				booleanList.add(false);

		}

		return booleanList;
	}

	public static boolean isSubsequence(String t, String s) {

		if (t.length() == 0 && s.length() == 0) {
			return true;
		}

		if (t.length() == 0 && s.length() != 0)
			return false;

		int i = 0;
		int j = 0;

		while (i < t.length() && j < s.length()) {

			if (t.charAt(i) == s.charAt(j)) {
				i++;
				j++;
			} else
				i++;

			if (i == t.length() && j < s.length()) {
				return false;
			}

		}

		return true;
	}
}
