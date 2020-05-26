package remove_duplicate_letters_316;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String args[]) {

		System.out.println(removeDuplicateLetters("ccddaabb"));
		System.out.println(removeDuplicateLetters("cbacdcbc"));
		System.out.println(removeDuplicateLetters("bbcaac"));
		System.out.println(removeDuplicateLetters("thesqtitxyetpxloeevdeqifkz"));

	}

	public static String globalString = new String();

	public static String removeDuplicateLetters(String str) {

		if (str.length() == 0)
			return "";
		if (str.equals(""))
			return "";
		Set<Character> set = new HashSet<Character>();

		for (int i = 0; i < str.length(); i++) {
			set.add(str.charAt(i));
		}

		globalString = new String(str);

		String temp = new String();

		for (Character ch : set) {
			temp += ch;
		}
		List<String> list = new ArrayList<String>();
		
		list = permute(temp, 0, temp.length() - 1, list);
		
		Collections.sort(list);

		return list.get(0);
	}

	private static List<String> permute(String str, int l, int r, List<String> list) {
		if (l == r) {
			if (isSubSequence(str, globalString, str.length(), globalString.length()))
				list.add(str);
		} else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r, list);
				str = swap(str, l, i);
			}
		}
		return list;
	}

	public static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	static boolean isSubSequence(String str1, String str2, int m, int n) {

		if (m == 0)
			return true;
		if (n == 0)
			return false;

		if (str1.charAt(m - 1) == str2.charAt(n - 1))
			return isSubSequence(str1, str2, m - 1, n - 1);

		return isSubSequence(str1, str2, m, n - 1);
	}

}
