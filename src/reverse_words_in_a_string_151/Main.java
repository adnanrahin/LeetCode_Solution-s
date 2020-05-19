package reverse_words_in_a_string_151;

public class Main {

	public static void main(String args[]) {

		// System.out.println(reverseWords("The sky is blue"));
		System.out.print(reverseWords(" 1"));
		System.out.println("#");
	}

	public static String reverseWords(String s) {

		String[] words = s.trim().split(" +");
		StringBuffer sb = new StringBuffer();
		for (int i = words.length - 1; i > 0; i--) {
			sb.append(words[i] + " ");
		}
		
		sb.append(words[0]);
		
		return sb.toString();

	}
}
