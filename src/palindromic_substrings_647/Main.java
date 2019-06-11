package palindromic_substrings_647;

public class Main {

	public static void main(String args[]) {

		System.out.println(countSubstrings("abbacv"));
		System.out.println(countSubstrings("abc"));
		System.out.println(countSubstrings("aba"));
		System.out.println(countSubstrings("abbacc"));
		System.out.println(countSubstrings("aaa"));

	}

	public static int countSubstrings(String s) {

		if (s.length() == 0)
			return 0;

		boolean[][] b = new boolean[s.length()][s.length()];
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j)
					b[j][i] = true;
				else if (i - j == 1)
					b[j][i] = (s.charAt(i) == s.charAt(j));
				else
					b[j][i] = ((s.charAt(i) == s.charAt(j)) && b[j + 1][i - 1]);
				if (b[j][i])
					count++;
			}
		}

		return count;
	}

}

// image Link: https://drive.google.com/file/d/1xWT6LoT3nfTHIn4wyWrGA72FGAo55ds1/view?usp=sharing
