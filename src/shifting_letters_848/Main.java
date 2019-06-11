package shifting_letters_848;

public class Main {

	public static void main(String args[]) {
		System.out.println(shiftingLetters("abc", new int[] { 3, 5, 9 }));
		System.out.println(shiftingLetters("zzz", new int[] { 3, 3, 3 }));
		System.out.println(shiftingLetters("bad", new int[] { 10, 20, 30 }));
		System.out.println(shiftingLetters("ktmq", new int[] { 10, 26, 8, 2 }));
	}

	public static String shiftingLetters(String S, int[] shifts) {

		StringBuffer sb = new StringBuffer();

		long sum = 0;

		for (int i = 0; i < shifts.length; i++) {
			sum += shifts[i];
		}

		for (int i = 0; i < S.length(); i++) {

			long mod = sum % 26;

			if (S.charAt(i) + mod > 'z') {

				long m = S.charAt(i) + mod - 1;
				long n = m - 'z';
				char a = (char) (n + 'a');
				sb.append(a);
			} else {
				char r = (char) (S.charAt(i) + mod);
				sb.append(r);
			}

			sum -= shifts[i];

		}
		return sb.toString();

	}

}
