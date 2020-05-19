package length_of_last_word_58;

public class Main {

	public static void main(String args[]) {
		System.out.println(lengthOfLastWord("abfsajfdk j32423 lkj////jjrkr3223lkj"));
	}

	public static int lengthOfLastWord(String s) {
		
		s = s.replaceAll("[^a-zA-Z]", " ");
		
		s = s.trim().replaceAll(" +", " ");;
		
		String []strings = s.split(" ");
		
		return strings[strings.length - 1].length();
	}
}
