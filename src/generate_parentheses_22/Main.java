package generate_parentheses_22;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {

		System.out.println(generateParenthesis(3));
		System.out.println(generateParenthesis(2));

	}

	public static List<String> generateParenthesis(int n) {
		
		if(n == 0) return new ArrayList<String>();
		
		List<String> list = new ArrayList<String>();

		recur(n, "", 0, 0, list);

		return list;
	}

	public static void recur(int n, String str, int open, int close, List<String> list) {

		if (str.length() == n * 2) {
			list.add(str);
			return;
		}

		if (open < n)
			recur(n, str + "(", open + 1, close, list);

		if (close < open)
			recur(n, str + ")", open, close + 1, list);

	}
}
