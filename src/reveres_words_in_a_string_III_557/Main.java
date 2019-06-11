package reveres_words_in_a_string_III_557;

public class Main {

	public static void main(String args[]) {
		String input = "Let's take LeetCode contest";
		System.out.println(reveres_words(input));
	}
	
	public static String reveres_words(String str) {
		
		String arr[] = str.split(" ");
		String temp = new String();
		
		for(int i=0; i<arr.length; i++) {
			if(i == 0) {
				temp = temp + new StringBuilder(arr[i]).reverse().toString();
			}
			else temp = temp + " " + new StringBuilder(arr[i]).reverse().toString();
		}
		return temp;
		
	}
	
}
