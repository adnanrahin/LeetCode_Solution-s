package longest_valid_parentheses_32;

import java.util.Stack;

public class Main {

	public static void main(String args[]) {

		System.out.println(longestValidParentheses(")()()("));
		System.out.println(longestValidParentheses("(()"));
		System.out.println(longestValidParentheses("(()(()("));
		System.out.println(longestValidParentheses("(()))"));
		System.out.println(longestValidParentheses("((())()(((())())"));
	}

	public static int longestValidParentheses(String s) {

		if (s.length() == 0)
			return 0;

		int max = 0;

		Stack<Integer> stack = new Stack<>();
		stack.push(-1);

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '(')
				stack.push(i);

			else {
				stack.pop();
				if (!stack.isEmpty())
					max = Math.max(max, i - stack.peek());
				else
					stack.push(i);
			}

		}

		return max;
	}

}
