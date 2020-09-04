package shifting_letters_848;

public class Main {

	public static void main(String[] args) {

		System.out.println(new PrefixSumSolution().shiftingLetters("mkgfzkkuxownxvfvxasy",
				new int[]{505870226, 437526072, 266740649, 224336793, 532917782, 311122363, 567754492, 595798950,
						81520022, 684110326, 137742843, 275267355, 856903962, 148291585, 919054234, 467541837,
						622939912, 116899933, 983296461, 536563513}));

	}

	public static class PrefixSumSolution {
		public String shiftingLetters(String S, int[] shifts) {

			char[] charArray = S.toCharArray();

			long sum = 0;

			for (int i = 0; i < shifts.length; i++) sum += shifts[i];

			for (int i = 0; i < shifts.length; i++) {
				long shift = ((charArray[i] - 'a') + sum) % 26;
				charArray[i] = (char) (shift + 'a');
				sum -= shifts[i];
			}

			return new String(charArray);
		}
	}

	public static class BruteForce { // Brute Force solution will lead us to the TLE
		public static String shiftingLetters(String S, int[] shifts) {

			char[] charArray = S.toCharArray();

			for (int i = 1; i <= shifts.length; i++) {
				for (int j = 0; j < i; j++) {
					int shift = (charArray[j] + shifts[i - 1]) % 'z';
					charArray[j] = (char) (shift);
				}
			}

			return new String(charArray);
		}
	}

}
