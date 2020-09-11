package camelcase_matching_1023;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
		String pattern = "FB";
		System.out.println(camelMatch(queries, pattern));
	}

	public static List<Boolean> camelMatch(String[] queries, String pattern) {
		List<Boolean> solution = new ArrayList<>();
		for (String word : queries) {
			solution.add(isSubsequence(word, pattern));
		}
		return solution;
	}

	public static boolean isSubsequence(String text, String pattern) {
		int patCamelCount = 0;
		int textCamelCount = 0;

		if (pattern.length() > text.length()) return false;

		int i = 0, j = 0;

		while (i < pattern.length() && j < text.length()) {

			if (Character.isUpperCase(text.charAt(j))) textCamelCount++;
			if (pattern.charAt(i) == text.charAt(j)) {
				if (Character.isUpperCase(pattern.charAt(i))) patCamelCount++;
				i++;
			}
			j++;
		}

		while (j < text.length()) {
			if (Character.isUpperCase(text.charAt(j))) textCamelCount++;
			j++;
		}

		return i == pattern.length() && patCamelCount == textCamelCount;
	}


}
