package long_pressed_name_925;

import java.util.Arrays;

public class Main {

	public static void main(String args[]) {

		System.out.println(isLongPressedName("saeed", "ssaaed"));
		System.out.println(isLongPressedName("alex", "aaleex"));
		System.out.println(isLongPressedName("leelee", "lleeelee"));
		System.out.println(isLongPressedName("laiden", "laiden"));
		System.out.println(isLongPressedName("kikcxmvzi", "kiikcxxmmvvzz"));
	}

	public static boolean isLongPressedName(String name, String typed) {

		int name_arr[] = new int[256];

		int typed_arr[] = new int[256];

		Arrays.fill(name_arr, 0);
		Arrays.fill(typed_arr, 0);

		for (int i = 0; i < name.length(); i++) {
			name_arr[name.charAt(i)]++;
		}

		for (int i = 0; i < typed.length(); i++) {
			typed_arr[typed.charAt(i)]++;
		}

		for (int i = 0; i < 256; i++) {
			if (typed_arr[i] < name_arr[i]) {
				return false;
			}
		}

		if (!isSubSequence(name, typed))
			return false;

		return true;
	}

	public static boolean isSubSequence(String str1, String str2) {

		int m = str1.length();
		int n = str2.length();

		int j = 0;

		for (int i = 0; i < n && j < m; i++)
			if (str1.charAt(j) == str2.charAt(i))
				j++;

		return (j == m);
	}

}
