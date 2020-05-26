package valid_parentheses_20;

import java.util.Stack;

public class Main {

	public static void main(String args[]) {

		System.out.println(isValid("(()"));

	}

	public static boolean isValid(String s) {

		if (s.length() == 1)
			return false;

		if (s.length() == 0)
			return true;

		if (s.charAt(0) == '}' || s.charAt(0) == ')' || s.charAt(0) == ']')
			return false;

		Stack<Character> valid = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			try {
				if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
					valid.push(s.charAt(i));
				else if (s.charAt(i) == ')') {
					if (valid.peek() != '(')
						return false;
					else
						valid.pop();
				} else if (s.charAt(i) == '}') {
					if (valid.peek() != '{')
						return false;
					else
						valid.pop();
				} else if (s.charAt(i) == ']') {
					if (valid.peek() != '[')
						return false;
					else
						valid.pop();
				}
			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}

		}

		if (valid.size() != 0)
			return false;

		return true;
	}

}
