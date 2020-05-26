package buddy_strings_859;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String args[]) {

		System.out.println(buddyStrings("ab", "ba"));
		System.out.println(buddyStrings("aaaaaaabc", "aaaaaaacb"));
		System.out.println(buddyStrings("ab", "ab"));
		System.out.println(buddyStrings("aa", "aa"));
		System.out.println(buddyStrings("abcd", "badc"));
		System.out.println(buddyStrings("abab", "abab"));
		System.out.println(buddyStrings("abcd", "abcd"));

	}

	public static boolean buddyStrings(String A, String B) {

		if (A.length() != B.length())
			return false;
		if (A.length() == 0 || B.length() == 0)
			return false;
		if (A.length() == 2 && B.length() == 2) {
			if (!A.equals(B)) {
				A = swap(A, 0, 1);
				if (A.equals(B))
					return true;
				else
					return false;
			} else if (A.equals(B)) {
				A = swap(A, 0, 1);
				if (!A.equals(B))
					return false;
				else
					return true;
			}

		}

		if (A.equals(B)) {
			Set<Character> set = new HashSet<>();
			for (int i = 0; i < A.length(); i++) {
				set.add(A.charAt(i));
			}
			if (set.size() == A.length()) {
				return false;
			}
		}

		int[] arr = new int[2];
		arr[0] = -1;
		arr[1] = -1;
		int l = 0;
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) != B.charAt(i)) {
				arr[l++] = i;
				if (l == 2)
					break;
			}
		}

		try {
			A = swap(A, arr[0], arr[1]);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (A.equals(B))
			return true;

		return false;
	}

	public static String swap(String str, int i, int j) {
		char ch[] = str.toCharArray();
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
		return String.valueOf(ch);
	}

}
