package repeated_string_match_686;

public class Main {

	public static void main(String[] args) {

		String pattern = "abcd";
		String text = "cdabcdab";
		System.out.println(RabinKarp(pattern, text));
		System.out.println(repeatedStringMatch(pattern, text));

	}

	public static int repeatedStringMatch(String pattern, String text) {
		int count = 1;
		int tn = text.length();
		String temp = pattern;
		while(temp.length() < tn) {
			count++;
			temp = temp + pattern;
		}
		
		if(RabinKarp(text, temp)) {
			return count ;
		}
		else {
			return(RabinKarp(text, temp+temp)) ? count+1 : -1;
		}
	}
	
	public static boolean RabinKarp(String pattern, String text) {

		int m = pattern.length();
		int n = text.length();
		int largePrime = 599;
		int patternHash = 0, textHash = 0;
		int am = 1;

		for (int i = 0; i < pattern.length(); i++) {
			patternHash = (patternHash * 256 + pattern.charAt(i)) % largePrime;
			textHash = (textHash * 256 + text.charAt(i)) % largePrime;
			if (i < pattern.length() - 1)
				am = (am * 256) % largePrime;
		}

		for (int i = 0; i < n - m; ++i) {
			if (patternHash == textHash && pattern.equals(text.substring(i, i + m))) {
				return true;
			}

			textHash = (((textHash - text.charAt(i) * am) * 256) + text.charAt(i + m)) % largePrime;

			if (textHash < 0)
				textHash += largePrime;
		}

		if (patternHash == textHash && pattern.equals(text.substring(n - m, n)))
			return true;

		return false;
	}

}